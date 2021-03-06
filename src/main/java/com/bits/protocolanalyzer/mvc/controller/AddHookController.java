package com.bits.protocolanalyzer.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bits.protocolanalyzer.analyzer.link.EthernetAnalyzer;
import com.bits.protocolanalyzer.analyzer.link.LinkLayerEventBus;
import com.bits.protocolanalyzer.analyzer.network.Ipv4Analyzer;
import com.bits.protocolanalyzer.analyzer.network.NetworkLayerEventBus;
import com.bits.protocolanalyzer.analyzer.transport.TcpAnalyzer;
import com.bits.protocolanalyzer.analyzer.transport.TransportLayerEventBus;
import com.google.common.eventbus.EventBus;

/**
 * 
 * @author crygnus
 *
 */

@Controller
@RequestMapping("/addHook")
public class AddHookController {

    @RequestMapping("/ethernetHook")
    public ModelAndView addEthernetHook() {
        EventBus linkLayerEventBus = LinkLayerEventBus.getLinkLayerEventBus();
        linkLayerEventBus.register(new EthernetAnalyzer());
        ModelAndView mav = new ModelAndView("addHook");
        mav.addObject("addHookMsg",
                "Hook for Ethernet analyzer is successfully added!");
        return mav;
    }

    @RequestMapping("/ipHook")
    public ModelAndView addIPHook() {
        EventBus networkLayerEventBus = NetworkLayerEventBus
                .getNetworkLayerEventBus();
        networkLayerEventBus.register(new Ipv4Analyzer());
        ModelAndView mav = new ModelAndView("addHook");
        mav.addObject("addHookMsg",
                "Hook for IP analyzer is successfully added!");
        return mav;
    }

    @RequestMapping("/tcpHook")
    public ModelAndView addTCPHook() {
        EventBus transportLayerEventBus = TransportLayerEventBus
                .getTransportLayerEventBus();
        transportLayerEventBus.register(new TcpAnalyzer());
        ModelAndView mav = new ModelAndView("addHook");
        mav.addObject("addHookMsg",
                "Hook for TCP analyzer is successfully added!");
        return mav;
    }
}
