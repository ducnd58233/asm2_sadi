package com.sadi.asm2.controller.Statistic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Production.Product;
import com.sadi.asm2.service.Statistic.StatisticService;

@RestController
@RequestMapping(path="statistic")
public class StatisticController {
	@Autowired
	private StatisticService statisticService;
	
	@RequestMapping(path = "/revenue", method = RequestMethod.GET)
	public double getRevenue() {
		return statisticService.getRevenue();
	}

	@RequestMapping(path = "/revenueByCustomer", method = RequestMethod.GET)
	public double getRevenueByCustomer(@RequestParam int customerId) {
		return statisticService.getRevenueByCustomer(customerId);
	}

	@RequestMapping(path = "/revenueByStaff", method = RequestMethod.GET)
	public double getRevenueByStaff(@RequestParam int staffId) {
		return statisticService.getRevenueByStaff(staffId);
	}

	@RequestMapping(path = "/revenueByPeriod", method = RequestMethod.GET)
	public double getRevenueInPeriod(@RequestParam Date startDate, @RequestParam Date endDate) {
		return statisticService.getRevenueInPeriod(startDate, endDate);
	}

	@RequestMapping(path = "/inventoryInfo", method = RequestMethod.GET)
	public List<Product> getWarehouseProducts(@RequestParam Date date) {
		return statisticService.getWarehouseProducts(date);
	}
}
