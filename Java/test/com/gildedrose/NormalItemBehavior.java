package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class NormalItemBehavior {

	@Test
	public void qualityDecreasesWithSellInBeforeDue() {
		Item item = new Item("Something", 10, 10);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(9, item.quality);
		Assert.assertEquals(9, item.sellIn);
	}

	@Test
	public void qualityDecreasesTwiceAsFastWithSellInAfterDue() {
		Item item = new Item("Something", 0, 10);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(8, item.quality);
		Assert.assertEquals(-1, item.sellIn);
	}

	@Test
	public void qualityIsNeverLessThanZero() {
		Item item = new Item("Something", 0, 0);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(0, item.quality);
		Assert.assertEquals(-1, item.sellIn);
	}

}
