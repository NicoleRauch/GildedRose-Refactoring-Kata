package com.gildedrose;

public class QualityUpdater {

	static void updateQualityFor(Item item) {
		new GildedRose(new Item[]{ item }).updateQuality();
	}

}
