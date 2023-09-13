/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almisk.rtf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import oracle.xdo.XDOException;
import oracle.xdo.template.FOProcessor;
import oracle.xdo.template.RTFProcessor;

/**
 * REST Web Service
 *
 * @author gautham.r
 */
@Path("/rest")
public class RestResource {

    @Context
    private UriInfo context;
    DbPackageCall dbPackageCall = new DbPackageCall();

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {

    }

    /**
     * Retrieves representation of an instance of com.almisk.rtf.RestResource
     *
     * @return an instance of java.lang.String
     */
    @Path("/offer/{offerNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response OffferReport(@PathParam("offerNumber") String offerNumber) {

        String fileName = offerNumber + ".pdf";

        String xmlData = dbPackageCall.offerXml(offerNumber);
        String filePath = "/u01/data/report/Offer_Form.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }

    @Path("/booking/{bookingNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response bookingReport(@PathParam("bookingNumber") String bookingNumber) {
        String fileName = bookingNumber + ".pdf";
        String xmlData = dbPackageCall.bookingXml(bookingNumber);
        String filePath = "/u01/data/report/Booking_Form.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }

    @Path("/bookingline/receipt/{receiptNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response bookingReceiptLineReport(@PathParam("receiptNumber") String receiptNumber) {
        String fileName = receiptNumber + ".pdf";
        String xmlData = dbPackageCall.bookingReceiptXml(receiptNumber);
        String filePath = "/u01/data/report/Booking Line Receipt.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }

    @Path("/booking/receipt/{bookingNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response bookingReceiptReport(@PathParam("bookingNumber") String bookingNumber) {
        String fileName = bookingNumber + ".pdf";
        String xmlData = dbPackageCall.provisionalBookingXml(bookingNumber);
        String filePath = "/u01/data/report/Booking Receipt.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }

    @Path("/recomendation/{recomendationNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response recomendationReport(@PathParam("recomendationNumber") String recomendationNumber) {
        String fileName = recomendationNumber + ".pdf";
        String xmlData = dbPackageCall.recomendationXml(recomendationNumber);
        String filePath = "/u01/data/report/Reservation_Form.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }

    @Path("/recomendationline/receipt/{receiptNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response recomendationLineReceiptReport(@PathParam("receiptNumber") String receiptNumber) {
        String fileName = receiptNumber + ".pdf";
        String xmlData = dbPackageCall.recommendationReceiptXml(receiptNumber);
        String filePath = "/u01/data/report/Recommendation Line Receipt.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }

    @Path("/recomendation/receipt/{recomendationNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)

    public Response provisionalReceiptReport(@PathParam("recomendationNumber") String recomendationNumber) {
        String fileName = recomendationNumber + ".pdf";
        String xmlData = dbPackageCall.provisionalReceiptXml(recomendationNumber);
        String filePath = "/u01/data/report/Recommendation Receipt.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }

    @Path("/lease/sharjah/{leaseNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response sharjahReport(@PathParam("leaseNumber") String leaseNumber) {
        String fileName = leaseNumber + ".pdf";
        String xmlData = dbPackageCall.sharjahXml(leaseNumber);
        String filePath = "/u01/data/report/Tendancy Contract-Sharjah.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }

    @Path("/lease/dubai/{leaseNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response dubaiReport(@PathParam("leaseNumber") String leaseNumber) {
        String fileName = leaseNumber + ".pdf";
        String xmlData = dbPackageCall.dubaiXml(leaseNumber);
        String filePath = "/u01/data/report/Tendancy Contract - Dubai.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }

    @Path("/tax/invoice/{leaseNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response taxInvoiceReport(@PathParam("leaseNumber") String leaseNumber) {
        String fileName = leaseNumber + ".pdf";
        String xmlData = dbPackageCall.taxInvoiceXml(leaseNumber);
        String filePath = "/u01/data/report/Tax_Invoice_Report.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }
    @Path("/recomendation/receiptack/{recomendationNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)

    public Response recomendationReceiptAck(@PathParam("recomendationNumber") String recomendationNumber) {
        String fileName = recomendationNumber + ".pdf";
        String xmlData = dbPackageCall.recomendationReceiptAckXml(recomendationNumber);
        String filePath = "/u01/data/report/Recommendation Receipt_Ack.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }

    public byte[] rtfReport(String xmlData, String filePath) {
        InputStream fiS = null;
        ByteArrayInputStream xslInStream = null;
        ByteArrayInputStream dataStream = null;
        ByteArrayOutputStream pdfOutStream = null;

        byte[] dataBytes = null;
        byte outFileTypeByte = 0;
        try {

            fiS = new FileInputStream(new File(filePath));
            outFileTypeByte = FOProcessor.FORMAT_PDF;

            RTFProcessor rtfP = new RTFProcessor(fiS);
            ByteArrayOutputStream xslOutStream = new ByteArrayOutputStream();
            rtfP.setOutput(xslOutStream);
            rtfP.process();
            xslInStream = new ByteArrayInputStream(xslOutStream.toByteArray());

            FOProcessor processor = new FOProcessor();
            processor.setConfig("/u01/data/font/xdo.cfg");
            dataStream = new ByteArrayInputStream(xmlData.getBytes());

            processor.setData(dataStream);
            processor.setTemplate(xslInStream);

            pdfOutStream = new ByteArrayOutputStream();
            processor.setOutput(pdfOutStream);

            processor.setOutputFormat(outFileTypeByte);
            processor.generate();
            dataBytes = pdfOutStream.toByteArray();
        } catch (XDOException ex) {
            Logger.getLogger(RestResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RestResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataBytes;
    }
//individual
@Path("/OC_Recommendation_Line_Receipt/receipt/{receiptNumber}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response recomendationLineReceiptReport_oc(@PathParam("receiptNumber") String receiptNumber) {
        String fileName = receiptNumber + ".pdf";
        String xmlData = dbPackageCall.OC_Recommendation_Line_Receiptxml(receiptNumber);
        String filePath = "/u01/data/report/OC_Recommendation_Line_Receipt.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }
//summary
@Path("/OC_Recommendation_Receipt/receipt/{OtherChargesNo}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)

    public Response provisionalReceiptReport_oc(@PathParam("OtherChargesNo") String OtherChargesNo) {
        String fileName = OtherChargesNo + ".pdf";
        String xmlData = dbPackageCall.OC_Recommendation_Receiptxml(OtherChargesNo);
        String filePath = "/u01/data/report/OC_Recommendation_Receipt.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }
// ack
@Path("/OC_Recommendation_Receipt_Ack/receiptack/{OtherChargesNo}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)

    public Response recomendationReceiptAck_oc(@PathParam("OtherChargesNo") String OtherChargesNo) {
        String fileName = OtherChargesNo + ".pdf";
        String xmlData = dbPackageCall.OC_Recommendation_Receipt_Ackxml(OtherChargesNo);
        String filePath = "/u01/data/report/OC_Recommendation_Receipt_Ack.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }
  
     // bk_ack
@Path("/Booking_Receipt_Ack/receiptack/{BookingNo}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)

    public Response bookingReceiptAck_oc(@PathParam("BookingNo") String BookingNo) {
        String fileName = BookingNo + ".pdf";
        String xmlData = dbPackageCall.Booking_Receipt_Ackxml(BookingNo);
        String filePath = "/u01/data/report/Booking_Receipt_Ack.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }
         // cancellation proposed and final
@Path("/Cancellation/proposedAndFinal/{cancellationNo}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)

    public Response XXPM_CANCELLATION_REPORT(@PathParam("cancellationNo") String cancellationNo) {
        String fileName = cancellationNo + ".pdf";
        String xmlData = dbPackageCall.cancellation_propo_final_xml_CN(cancellationNo);
        String filePath = "/u01/data/report/Cancellation_Report.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }
     // cancellation proposed hist
@Path("/Cancellation/proposedAndFinal_H/{cancellationNo}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)

    public Response XXPM_PROPOSED_CANCELLATION_REPORT(@PathParam("cancellationNo") String cancellationNo) {
        String fileName = cancellationNo + ".pdf";
        String xmlData = dbPackageCall.cancellation_propo_H_xml_CN(cancellationNo);
        String filePath = "/u01/data/report/Proposed_Cancellation_Report.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }
// oc tax invoice
    @Path("/oc/tax/invoice/{ocNo}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)

    public Response OcTaxInvoiceReport(@PathParam("ocNo") String ocNo) {
        String fileName = ocNo + ".pdf";
        String xmlData = dbPackageCall.OcTaxInvoiceXml(ocNo);
        String filePath = "/u01/data/report/Tax_Invoice_Almisk.rtf";
        ResponseBuilder builder = Response.ok(rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }
}
