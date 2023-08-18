package com.mgulay.pocket.model

import com.google.gson.annotations.SerializedName
import com.mgulay.pocket.R

data class DataClass (
    @SerializedName("USD")
    var usd:USD?=USD(),
    @SerializedName("EUR")
    var eur:EUR?=EUR(),
    @SerializedName("GBP")
    var gbp : GBP?=GBP(),
    @SerializedName("RUB")
    var rub : RUB?=RUB(),
    @SerializedName("CAD")
    var cad:CAD?=CAD(),
    @SerializedName("THB")
    var thb:THB?=THB(),
    @SerializedName("CHF")
    var CHF: CHF?= CHF(),
    var AUD: AUD?= AUD(),
    @SerializedName("DKK")
    var DKK: DKK?= DKK(),
    @SerializedName("SEK")
    var SEK: SEK?= SEK(),
    @SerializedName("NOK")
    var NOK: NOK?= NOK(),
    @SerializedName("JPY")
    var JPY : JPY? = JPY(),
    @SerializedName("KWD")
    var KWD: KWD?= KWD(),
    @SerializedName("ZAR")
    var ZAR: ZAR?= ZAR(),
    @SerializedName("BHD")
    var BHD: BHD?= BHD(),
    @SerializedName("LYD")
    var LYD: LYD?= LYD(),
    @SerializedName("SAR")
    var SAR: SAR?= SAR(),
    @SerializedName("IQD")
    var IQD: IQD?= IQD(),
    @SerializedName("IRR")
    var IRR : IRR?= IRR(),
    @SerializedName("INR")
    var INR: INR?=INR(),
    @SerializedName("MXN")
    var MXN: MXN?=MXN(),
    @SerializedName("HUF")
    var HUF: HUF?=HUF(),
    @SerializedName("NZD")
    var NZD: NZD?=NZD(),
    @SerializedName("BRL")
    var BRL: BRL?=BRL(),
    @SerializedName("IDR")
    var IDR: IDR?=IDR(),
    @SerializedName("CZK")
    var CZK: CZK?=CZK(),
    @SerializedName("PLN")
    var PLN: PLN?=PLN(),
    @SerializedName("RON")
    var RON: RON?=RON(),
    @SerializedName("CNY")
    var CNY:CNY?=CNY(),
    @SerializedName("ARS")
    var ARS:ARS?=ARS(),
    @SerializedName("ALL")
    var ALL:ALL?=ALL(),
    @SerializedName("AZN")
    var AZN:AZN?=AZN(),
    @SerializedName("BAM")
    var BAM:BAM?=BAM(),
    @SerializedName("DZD")
    var DZD:DZD?=DZD(),
    @SerializedName("EGP")
    var EGP:EGP?=EGP(),
    @SerializedName("HRK")
    var HRK :HRK?=HRK(),
    @SerializedName("ISK")
    var ISK:ISK?=ISK(),
    @SerializedName("JOD")
    var JOD:JOD?=JOD(),
    @SerializedName("KRW")
    var KRW:KRW?=KRW(),
    @SerializedName("KZT")
    var KZT:KZT?=KZT(),
    @SerializedName("LBP")
    var LBP: LBP?=LBP(),
    @SerializedName("MAD")
    var MAD: MAD?=MAD(),
    @SerializedName("MKD")
    var MKD: MKD?=MKD(),
    @SerializedName("PKR")
    var PKR: PKR?=PKR(),
    @SerializedName("QAR")
    var QAR: QAR?=QAR(),
    @SerializedName("RSD")
    var RSD: RSD?=RSD(),
    @SerializedName("SGD")
    var SGD: SGD?=SGD(),
    @SerializedName("TWD")
    var TWD: TWD?=TWD(),
    @SerializedName("UAH")
    var UAH:UAH?=UAH(),
    @SerializedName("GEL")
    var GEL:GEL?=GEL(),
    @SerializedName("TND")
    var TND :TND?=TND(),
    @SerializedName("BGN")
    var BGN:BGN?=BGN(),

    @SerializedName("gram-altin")
    var gram_altin: Gram_altin?=Gram_altin(),
    @SerializedName("ceyrek-altin")
    var ceyrek_altin : Ceyrek_altin?=Ceyrek_altin(),
    @SerializedName("tam-altin")
    var tam_altin:Tam_altin?=Tam_altin(),
    @SerializedName("yarim-altin")
    var yarim_altin:Yarim_altin?=Yarim_altin(),
@SerializedName("cumhuriyet-altini")
var cumhuriyet_altini : Cumhuriyet_altini? = Cumhuriyet_altini(),
@SerializedName("ata-altin")
var ata_altin: Ata_altin?= Ata_altin(),
@SerializedName("14-ayar-altin")
var onDort_ayar_altin:onDort_ayar_altin?=onDort_ayar_altin(),
@SerializedName("18-ayar-altin")
var onSekiz_ayar_altin:onSekiz_ayar_altin?=onSekiz_ayar_altin(),
@SerializedName("besli-altin")
var besli_altin: Besli_altin?= Besli_altin(),
@SerializedName("gremse-altin")
var gremse_altin: Gremse_altin?= Gremse_altin(),
@SerializedName("resat-altin")
var resat_altin: Resat_altin?= Resat_altin(),
@SerializedName("hamit-altin")
var hamit_altin: Hamit_altin?= Hamit_altin(),
@SerializedName("gumus")
var gumus: Gumus?= Gumus()




)
class THB(
    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "THB"
    }
    var img= R.drawable.thailand
}


class CAD(
    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null
){
    override fun toString(): String {
        return "CAD"
    }
    var img=R.drawable.canada
}
class RUB(
    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null
){
    override fun toString(): String {
        return "RUB"
    }
    var img=R.drawable.russia
}
  class USD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
      override fun toString(): String {
          return "USD"
      }
      var img=R.drawable.usdcir
  }

 class EUR (

     @SerializedName("Alış") var Alis: String? = null,
     @SerializedName("Tür") var Tur: String? = null,
     @SerializedName("Satış") var Satis: String? = null,
     @SerializedName("Değişim") var Degisim: String? = null

){
     override fun toString(): String {
         return "EUR"
     }
 }
 class GBP (

     @SerializedName("Alış") var Alis: String? = null,
     @SerializedName("Tür") var Tur: String? = null,
     @SerializedName("Satış") var Satis: String? = null,
     @SerializedName("Değişim") var Degisim: String? = null

){
     override fun toString(): String {
         return "GBP"
     }
     var img=R.drawable.england
 }
class CHF (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "CHF"
    }
    var img=R.drawable.switzerland
}
class AUD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "AUD"
    }
    var img=R.drawable.australia
}
class DKK (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "DKK"
    }
    var img=R.drawable.denmark
}
class SEK (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "SEK"
    }
    var img=R.drawable.sweden
}
class NOK (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "NOK"
    }
    var img=R.drawable.norway
}
class JPY (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "JPY"
    }
    var img=R.drawable.japan
}
class KWD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "KWD"
    }
    var img=R.drawable.kuwait
}
class ZAR (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "ZAR"
    }
    var img=R.drawable.south_africa
}
class BHD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "BHD"
    }
    var img=R.drawable.bahrein
}
class LYD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "LYD"
    }
    var img=R.drawable.libya
}
class IQD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "IQD"
    }
    var img=R.drawable.iraq
}
class SAR (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "SAR"
    }
    var img=R.drawable.saudi
}
class IRR (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "IRR"
    }
    var img=R.drawable.iran
}
class INR (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "INR"
    }
    var img=R.drawable.india
}
class MXN (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "MXN"
    }
    var img=R.drawable.mexico
}
class HUF (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "HUF"
    }
    var img=R.drawable.hungary
}
class NZD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "NZD"
    }
    var img=R.drawable.newzeland
}
class BRL (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "BRL"
    }
    var img=R.drawable.brazil
}
class IDR (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "IDR"
    }
    var img=R.drawable.endonesia
}
class CZK (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "CZK"
    }
    var img=R.drawable.czech
}
class PLN (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "PLN"
    }
    var img=R.drawable.poland
}
class RON (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "RON"
    }
    var img=R.drawable.romania
}
class CNY (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "CNY"
    }
    var img=R.drawable.china
}
class ARS (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "ARS"
    }
    var img=R.drawable.argentina
}
class ALL (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "ALL"
    }
    var img=R.drawable.albenia
}
class AZN (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "AZN"
    }
    var img=R.drawable.azerbaijan
}
class BAM (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "BAM"
    }
    var img=R.drawable.bosnia
}
class DZD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "DZD"
    }
    var img=R.drawable.algeria
}
class EGP (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "EGP"
    }
    var img=R.drawable.egypt
}
class HRK (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "HRK"
    }
    var img=R.drawable.croatia
}
class ISK (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "ISK"
    }
    var img=R.drawable.newzeland
}
class JOD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "JOD"
    }
    var img=R.drawable.jordan
}
class KRW (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "KRW"
    }
    var img=R.drawable.south_korea
}
class KZT (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "KZT"
    }
    var img=R.drawable.kazakhstan
}
class LBP (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "LBP"
    }
    var img=R.drawable.lebanon
}
class MAD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "MAD"
    }
    var img=R.drawable.morocco
}
class MKD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "MKD"
    }
    var img=R.drawable.macedonia
}
class PKR (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "PKR"
    }
    var img=R.drawable.pakistan
}
class QAR (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "QAR"
    }
    var img=R.drawable.qatar
}
class RSD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "RSD"
    }
    var img=R.drawable.serbia
}
class SGD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "SGD"
    }
    var img=R.drawable.singapore
}
class TWD (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "TWD"
    }
    var img=R.drawable.taiwan
}
class UAH (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "UAH"
    }
    var img=R.drawable.ukrain
}
class GEL (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "GEL"
    }
    var img=R.drawable.georgia
}
class TND (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "TND"
    }
    var img=R.drawable.tunusia
}
class BGN (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "BGN"
    }
    var img=R.drawable.bulgaria
}
 class Gram_altin (

     @SerializedName("Alış") var Alis: String? = null,
     @SerializedName("Tür") var Tur: String? = null,
     @SerializedName("Satış") var Satis: String? = null,
     @SerializedName("Değişim") var Degisim: String? = null
){
     override fun toString(): String {
         return "GRAM"
     }
     var img=R.drawable.gold
 }
class Tam_altin(
    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null
){
    override fun toString(): String {
        return "Tam Altın"
    }
    var img=R.drawable.gold
}
 class Ceyrek_altin (

     @SerializedName("Alış") var Alis: String? = null,
     @SerializedName("Tür") var Tur: String? = null,
     @SerializedName("Satış") var Satis: String? = null,
     @SerializedName("Değişim") var Degisim: String? = null

){
     override fun toString(): String {
         return "ÇEYREK"
     }
     var img=R.drawable.gold
 }
class Yarim_altin (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "YARIM"
    }
    var img=R.drawable.gold
}
class Cumhuriyet_altini (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "CUMHURİYET"
    }
    var img=R.drawable.gold
}
class Ata_altin (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "ATA"
    }
    var img=R.drawable.gold
}
class onDort_ayar_altin (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "14 AYAR"
    }
    var img=R.drawable.gold
}
class onSekiz_ayar_altin (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "18 AYAR"
    }
    var img=R.drawable.gold
}

class Besli_altin (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "BEŞLİ"
    }
    var img=R.drawable.gold
}
class Gremse_altin (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "GRAMSE"
    }
    var img=R.drawable.gold
}
class Hamit_altin (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "HAMİT"
    }
    var img=R.drawable.gold
}
class Resat_altin (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "REŞAT"
    }
    var img=R.drawable.gold
}
class Gumus (

    @SerializedName("Alış") var Alis: String? = null,
    @SerializedName("Tür") var Tur: String? = null,
    @SerializedName("Satış") var Satis: String? = null,
    @SerializedName("Değişim") var Degisim: String? = null

){
    override fun toString(): String {
        return "GÜMÜŞ"
    }
    var img=R.drawable.silver
}
