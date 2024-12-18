package pl.futurecollars.invoicing.controller.invoice

import org.springframework.http.MediaType
import pl.futurecollars.invoicing.controller.AbstractControllerTest
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static pl.futurecollars.invoicing.helpers.TestHelpers.invoice
import static pl.futurecollars.invoicing.helpers.TestHelpers.resetIds

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@Unroll
class InvoiceControllerIntegrationTest extends AbstractControllerTest {

    def "empty array is returned when no invoices were added"() {
        expect:
        getAllInvoices() == []
    }

    def "add invoice returns sequential id"() {
        expect:
        def firstId = addInvoiceAndReturnId(invoice(1))
        addInvoiceAndReturnId(invoice(2)) == firstId + 1
        addInvoiceAndReturnId(invoice(3)) == firstId + 2
        addInvoiceAndReturnId(invoice(4)) == firstId + 3
        addInvoiceAndReturnId(invoice(5)) == firstId + 4
    }

    def "all invoices are returned when getting all invoices"() {
        given:
        def numberOfInvoices = 3
        def expectedInvoices = addUniqueInvoices(numberOfInvoices)

        when:
        def invoices = getAllInvoices()

        then:
        invoices.size() == numberOfInvoices
        resetIds(invoices) == resetIds(expectedInvoices)
    }

    def "correct invoice is returned when getting by id"() {
        given:
        def expectedInvoices = addUniqueInvoices(5)
        def expectedInvoice = expectedInvoices.get(2)

        when:
        def invoice = getInvoiceById(expectedInvoice.getId())

        then:
        resetIds(invoice) == resetIds(expectedInvoice)
    }

    def "404 is returned when invoice id is not found when getting invoice by id [#id]"() {
        given:
        addUniqueInvoices(11)

        expect:
        mockMvc.perform(
                get("$INVOICE_ENDPOINT/$id")
        )
                .andExpect(status().isNotFound())

        where:
        id << [-100, -2, -1, 0, 168, 1256]
    }

    def "404 is returned when invoice id is not found when deleting invoice [#id]"() {
        given:
        addUniqueInvoices(11)

        expect:
        mockMvc.perform(
                delete("$INVOICE_ENDPOINT/$id")
                        .with(csrf())
        )
                .andExpect(status().isNotFound())

        where:
        id << [-100, -2, -1, 0, 12, 13, 99, 102, 1000]
    }

    def "404 is returned when invoice id is not found when updating invoice [#id]"() {
        given:
        addUniqueInvoices(11)

        expect:
        mockMvc.perform(
                put("$INVOICE_ENDPOINT/$id")
                        .content(invoiceAsJson(1))
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(csrf())
        )
                .andExpect(status().isNotFound())

        where:
        id << [-100, -2, -1, 0, 12, 13, 99, 102, 1000]
    }

    def "invoice can be modified"() {
        given:
        def id = addInvoiceAndReturnId(invoice(4))
        def updatedInvoice = invoice(1)
        updatedInvoice.id = id

        expect:
        mockMvc.perform(
                put("$INVOICE_ENDPOINT/$id")
                        .content(jsonService.toJson(updatedInvoice))
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(csrf())
        )
                .andExpect(status().isNoContent())

        def invoiceFromDbAfterUpdate = resetIds(getInvoiceById(id)).toString()
        def expectedInvoice = resetIds(updatedInvoice).toString()
        invoiceFromDbAfterUpdate == expectedInvoice
    }

    def "invoice can be deleted"() {
        given:
        def invoices = addUniqueInvoices(69)

        expect:
        invoices.each { invoice -> deleteInvoice(invoice.getId()) }
        getAllInvoices().size() == 0
    }

}
