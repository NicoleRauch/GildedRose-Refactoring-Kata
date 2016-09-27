package com.gildedrose;

public class QualityUpdater {

	static void updateQualityFor(Item item) {
		Item[] items = new Item[1];
		items[0] = item;
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
	}

}
