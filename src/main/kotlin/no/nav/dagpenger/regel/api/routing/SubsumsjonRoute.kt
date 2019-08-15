package no.nav.dagpenger.regel.api.routing

import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import no.nav.dagpenger.regel.api.BadRequestException
import no.nav.dagpenger.regel.api.db.SubsumsjonId
import no.nav.dagpenger.regel.api.db.SubsumsjonStore

internal fun Route.subsumsjon(store: SubsumsjonStore) {
    authenticate {
        route("subsumsjon/") {
            get("/{subsumsjonsid}") {
                val subsumsjonsId = call.parameters["subsumsjonsid"] ?: throw BadRequestException()
                store.getSubsumsjon(subsumsjonsId).toJson().let {
                    call.respond(HttpStatusCode.OK, it)
                }
            }
            get("/result/{subsumsjonsid}") {
                val subsumsjonsId = call.parameters["subsumsjonsid"]?.let { SubsumsjonId(it) } ?: throw BadRequestException()
                store.getSubsumsjonByResult(subsumsjonsId).toJson().let {
                    call.respond(HttpStatusCode.OK, it)
                }
            }
        }
    }
}
