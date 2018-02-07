package com.github.ewoij.openminted.components.date_range_annotator;

import java.io.IOException;
import java.util.Collection;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Assert;
import org.junit.Test;

import com.github.ewoij.openminted.components.date_range_annotator.Dates.DateRange;

public class RutaTest {

	@Test
	public void test() throws IOException, UIMAException {
		JCas jcas = JCasFactory.createJCas();
		jcas.setDocumentText("4000 BP");
		AnalysisEngineDescription aed = AnalysisEngineFactory.createEngineDescriptionFromPath("target/generated-sources/ruta/descriptor/com/github/ewoij/openminted/components/date_range_annotator/MainRutaAnalysisEngine.xml");
		SimplePipeline.runPipeline(jcas, aed);
		Collection<DateRange> select = JCasUtil.select(jcas, DateRange.class);
		Assert.assertEquals(1, select.size());
		DateRange annotation = select.iterator().next();
		Assert.assertEquals(4000, annotation.getFrom());
		Assert.assertEquals(4000, annotation.getTo());
	}

}
