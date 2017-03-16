package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {

        List<Advertisement> potentialAdvertisements = new ArrayList<>();
        List<Advertisement> optimalVideoList = null;
        JewHelper jewHelper = null;
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getDuration() <= this.timeSeconds && advertisement.getHits() > 0) {
                potentialAdvertisements.add(advertisement);
            }
        }

        if (!potentialAdvertisements.isEmpty()) {
            jewHelper = new JewHelper(potentialAdvertisements);
            optimalVideoList = jewHelper.getBestAdvList();
        } else throw new NoVideoAvailableException();

        Collections.sort(optimalVideoList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) (o1.getAmountPerOneDisplaying() == o2.getAmountPerOneDisplaying()
                        ? (o1.getAmountPerSecond() - o2.getAmountPerSecond()) * 1000000
                        : o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            }
        });

        StatisticManager.getInstance().register(
                new VideoSelectedEventDataRow(
                        optimalVideoList,
                        jewHelper.getBestAmountOfAllVideo(),
                        jewHelper.getLongestTimeOfVideo()
                )
        );

        for (int i = 0; i < optimalVideoList.size(); i++) {
            Advertisement showingAd = optimalVideoList.get(i);
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    showingAd.getName(),
                    showingAd.getAmountPerOneDisplaying(),
                    (int) (showingAd.getAmountPerSecond() * 1000)
            ));
            showingAd.revalidate();

        }
    }

    /*
1. сумма денег, полученная от показов, должна быть максимальной из всех возможных вариантов
2. общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа;
3. для одного заказа любой видео-ролик показывается не более одного раза;
4. если существует несколько вариантов набора видео-роликов с одинаковой суммой денег, полученной от показов, то:
4.1. выбрать тот вариант, у которого суммарное время максимальное;
4.2. если суммарное время у этих вариантов одинаковое, то выбрать вариант с минимальным количеством роликов;
5. количество показов у любого рекламного ролика из набора — положительное число.
     */

    private class JewHelper {

        List<Advertisement> potentialAdvertisements;

        private int bestAmountOfAllVideo = 0;
        private int longestTimeOfVideo = 0;
        private List<Advertisement> bestAdvList;

        public JewHelper(List<Advertisement> potentialAdvertisements) {
            this.potentialAdvertisements = potentialAdvertisements;
            recursiveSearch(this.potentialAdvertisements);
        }

        private void recursiveSearch(List<Advertisement> advertisementList) {
            int amountOfAd = 0;
            int sumOfAdTime = 0;
            for (Advertisement advertisement : advertisementList) {
                amountOfAd += advertisement.getAmountPerOneDisplaying();
                sumOfAdTime += advertisement.getDuration();
            }

            if (sumOfAdTime > timeSeconds) {
                for (int i = 0; i < advertisementList.size(); i++) {
                    List<Advertisement> tmpList = new ArrayList<>(advertisementList);
                    tmpList.remove(i);
                    recursiveSearch(tmpList);
                }
            } else {
                if (amountOfAd > bestAmountOfAllVideo) {
                    bestAdvList = advertisementList;
                } else if (amountOfAd == bestAmountOfAllVideo) {
                    if (sumOfAdTime > bestAmountOfAllVideo) {
                        bestAdvList = advertisementList;
                    } else if (sumOfAdTime == longestTimeOfVideo) {
                        if (advertisementList.size() < bestAdvList.size()) {
                            bestAdvList = advertisementList;
                        }
                    }
                }
                if (bestAdvList == advertisementList) {
                    bestAmountOfAllVideo = amountOfAd;
                    longestTimeOfVideo = sumOfAdTime;
                }
            }
        }

        public List<Advertisement> getBestAdvList() {
            return bestAdvList;
        }

        public int getBestAmountOfAllVideo() {
            return bestAmountOfAllVideo;
        }

        public int getLongestTimeOfVideo() {
            return longestTimeOfVideo;
        }
    }
}
