package no.nav.dagpenger.regel.api.models

import no.nav.dagpenger.events.Packet

internal object PacketKeys {
    const val BEHANDLINGSID = "behandlingsId"
    const val MANUELT_GRUNNLAG = "manueltGrunnlag"
    const val FORRIGE_GRUNNLAG = "forrigeGrunnlag"
    const val ANTALL_BARN = "antallBarn"
    const val HAR_AVTJENT_VERNE_PLIKT = "harAvtjentVerneplikt"
    const val BEREGNINGS_DATO = "beregningsDato"
    const val KONTEKST_TYPE = "kontekstType"
    const val KONTEKST_ID = "kontekstId"
    const val AKTØR_ID = "aktørId"
    const val BEHOV_ID = "behovId"
    const val GRUNNLAG_RESULTAT = "grunnlagResultat"
    const val GRUNNLAG_INNTEKTSPERIODER = "grunnlagInntektsPerioder"
    const val INNTEKT = "inntektV1"
    const val MINSTEINNTEKT_RESULTAT = "minsteinntektResultat"
    const val MINSTEINNTEKT_INNTEKTSPERIODER = "minsteinntektInntektsPerioder"
    const val PERIODE_RESULTAT = "periodeResultat"
    const val SATS_RESULTAT = "satsResultat"
    const val OPPFYLLER_KRAV_TIL_FANGST_OG_FISK = "oppfyllerKravTilFangstOgFisk"
    const val BRUKT_INNTEKTSPERIODE = "bruktInntektsPeriode"
    const val PROBLEM = "system_problem"
    const val INNTEKTS_ID = "inntektsId"
    const val LÆRLING = "lærling"
    const val REGELVERKSDATO = "regelverksdato"
}

internal val Packet.behovId: BehovId
    get() = BehovId(this.getStringValue(PacketKeys.BEHOV_ID))

internal val Packet.kontekst: Kontekst
    get() {
        return Kontekst.valueOf(this.getStringValue(PacketKeys.KONTEKST_TYPE))
    }

internal val Packet.kontekstId: String
    get() = this.getStringValue(PacketKeys.KONTEKST_ID)
