package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class SulfurasItemBehavior {

	@Test
	public void qualityAndSellInNeverChange() {
		Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(10, item.quality);
		Assert.assertEquals(10, item.sellIn);
	}

	@Test
	public void qualityAndSellInNeverChangeAfterDue() {
		Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 10);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(10, item.quality);
		Assert.assertEquals(0, item.sellIn);
	}

	@Test
	public void qualityIsConstant() {
		Item item = new Item("Sulfuras, Hand of Ragnaros", -4, 500);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(500, item.quality);
		Assert.assertEquals(-4, item.sellIn);
	}

}
