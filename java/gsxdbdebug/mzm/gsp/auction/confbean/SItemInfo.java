/*    */ package mzm.gsp.auction.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SItemInfo implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int itemCfgId;
/*    */   public int itemWeight;
/*    */   public int itemBindType;
/*    */   public int moneyType;
/*    */   public int yuanBaoType;
/*    */   public int basePrice;
/*    */   public int premiumRate;
/*    */   public int bidBaseTime;
/*    */   public int bidOverTimeUnit;
/*    */   public int bidOverTimeMaxCount;
/*    */   public int bidEndCountDownTime;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 25 */     this.itemCfgId = Integer.valueOf(rootElement.attributeValue("itemCfgId")).intValue();
/* 26 */     this.itemWeight = Integer.valueOf(rootElement.attributeValue("itemWeight")).intValue();
/* 27 */     this.itemBindType = Integer.valueOf(rootElement.attributeValue("itemBindType")).intValue();
/* 28 */     this.moneyType = Integer.valueOf(rootElement.attributeValue("moneyType")).intValue();
/* 29 */     this.yuanBaoType = Integer.valueOf(rootElement.attributeValue("yuanBaoType")).intValue();
/* 30 */     this.basePrice = Integer.valueOf(rootElement.attributeValue("basePrice")).intValue();
/* 31 */     this.premiumRate = Integer.valueOf(rootElement.attributeValue("premiumRate")).intValue();
/* 32 */     this.bidBaseTime = Integer.valueOf(rootElement.attributeValue("bidBaseTime")).intValue();
/* 33 */     this.bidOverTimeUnit = Integer.valueOf(rootElement.attributeValue("bidOverTimeUnit")).intValue();
/* 34 */     this.bidOverTimeMaxCount = Integer.valueOf(rootElement.attributeValue("bidOverTimeMaxCount")).intValue();
/* 35 */     this.bidEndCountDownTime = Integer.valueOf(rootElement.attributeValue("bidEndCountDownTime")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 40 */     _os_.marshal(this.id);
/* 41 */     _os_.marshal(this.itemCfgId);
/* 42 */     _os_.marshal(this.itemWeight);
/* 43 */     _os_.marshal(this.itemBindType);
/* 44 */     _os_.marshal(this.moneyType);
/* 45 */     _os_.marshal(this.yuanBaoType);
/* 46 */     _os_.marshal(this.basePrice);
/* 47 */     _os_.marshal(this.premiumRate);
/* 48 */     _os_.marshal(this.bidBaseTime);
/* 49 */     _os_.marshal(this.bidOverTimeUnit);
/* 50 */     _os_.marshal(this.bidOverTimeMaxCount);
/* 51 */     _os_.marshal(this.bidEndCountDownTime);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 57 */     this.id = _os_.unmarshal_int();
/* 58 */     this.itemCfgId = _os_.unmarshal_int();
/* 59 */     this.itemWeight = _os_.unmarshal_int();
/* 60 */     this.itemBindType = _os_.unmarshal_int();
/* 61 */     this.moneyType = _os_.unmarshal_int();
/* 62 */     this.yuanBaoType = _os_.unmarshal_int();
/* 63 */     this.basePrice = _os_.unmarshal_int();
/* 64 */     this.premiumRate = _os_.unmarshal_int();
/* 65 */     this.bidBaseTime = _os_.unmarshal_int();
/* 66 */     this.bidOverTimeUnit = _os_.unmarshal_int();
/* 67 */     this.bidOverTimeMaxCount = _os_.unmarshal_int();
/* 68 */     this.bidEndCountDownTime = _os_.unmarshal_int();
/* 69 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\confbean\SItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */