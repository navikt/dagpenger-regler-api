package no.nav.dagpenger.regel.api.periode

import no.nav.dagpenger.regel.api.models.common.InntektsPeriode
import java.time.LocalDate
import java.time.LocalDateTime

data class PeriodeSubsumsjon(
    val subsumsjonsId: String,
    val opprettet: LocalDateTime, // todo: ZonedDateTime?
    val utfort: LocalDateTime, // todo: ZonedDateTime?,
    val faktum: PeriodeFaktum,
    val resultat: PeriodeResultat
)

data class PeriodeResultat(
    val antallUker: Int
)

data class PeriodeFaktum(
    val aktorId: String,
    val vedtakId: Int,
    val beregningsdato: LocalDate,
    val inntektsId: String,
    val harAvtjentVerneplikt: Boolean? = false,
    val oppfyllerKravTilFangstOgFisk: Boolean? = false,
    val bruktInntektsPeriode: InntektsPeriode? = null
)
