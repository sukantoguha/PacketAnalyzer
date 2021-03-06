/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bits.protocolanalyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bits.protocolanalyzer.persistence.entity.NetworkAnalyzerEntity;
import com.bits.protocolanalyzer.persistence.entity.PacketIdEntity;

/**
 *
 * @author amit
 */
public interface NetworkAnalyzerRepository extends
        JpaRepository<NetworkAnalyzerEntity, Long> {

    public NetworkAnalyzerEntity findByPacketIdEntity(
            PacketIdEntity packetIdEntity);

}
