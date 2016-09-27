package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class BackstagePassItemBehavior {

	@Test
	public void qualityIncreasesWithSellInBeforeDue() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 20,
				10);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(11, item.quality);
		Assert.assertEquals(19, item.sellIn);
	}

	@Test
	public void qualityIncreasesTwiceAsFastTenDaysInBeforeDue() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10,
				10);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(12, item.quality);
		Assert.assertEquals(9, item.sellIn);
	}

	@Test
	public void qualityIncreasesThreeceAsFastFiveDaysInBeforeDue() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(13, item.quality);
		Assert.assertEquals(4, item.sellIn);
	}

	@Test
	public void qualityIsZeroAfterDue() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(0, item.quality);
		Assert.assertEquals(-1, item.sellIn);
	}

	@Test
	public void qualityIsNeverLessThanZero() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(0, item.quality);
		Assert.assertEquals(-1, item.sellIn);
	}

	@Test
	public void qualityIsNeverMoreThanFifty() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49);
		QualityUpdater.updateQualityFor(item);
		Assert.assertEquals(50, item.quality);
		Assert.assertEquals(0, item.sellIn);
	}

}
