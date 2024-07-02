/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.flusso.osp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"it.mds.sdk.flusso.osp.controller","it.mds.sdk.flusso.osp",
		"it.mds.sdk.rest.persistence.entity","it.mds.sdk.libreriaregole.validator",
		"it.mds.sdk.flusso.osp.service","it.mds.sdk.flusso.osp.tracciato",
		"it.mds.sdk.gestoreesiti", "it.mds.sdk.flusso.osp.parser.regole",
		"it.mds.sdk.flusso.osp.parser.regole.conf",
		"it.mds.sdk.connettoremds"})
@OpenAPIDefinition(info=@Info(title = "SDK Ministero Della Salute - Flusso OSP", version = "0.0.1-SNAPSHOT", description = "Flusso Consumi Ospedalieri"))
public class FlussoOsp {

	public static void main(String[] args) {
		SpringApplication.run(FlussoOsp.class, args);
	}

}
