package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class AgedBrieItemBehavior {

	@Test
	public void qualityIncreasesConstantlyBeforeDue() {
		Item item = new Item("Aged Brie", 10, 10);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(11, item.quality);
		Assert.assertEquals(9, item.sellIn);
	}

	@Test
	public void qualityIncreasesTwiceAsFastAfterDue() {
		Item item = new Item("Aged Brie", 0, 10);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(12, item.quality);
		Assert.assertEquals(-1, item.sellIn);
	}

	@Test
	public void qualityIsAlwaysLessThanFifty() {
		Item item = new Item("Aged Brie", 0, 50);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(50, item.quality);
		Assert.assertEquals(-1, item.sellIn);
	}

}
