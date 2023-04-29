/*    */ package mzm.gsp.auction.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SAuctionActivityInfo implements Marshal
/*    */ {
/*    */   public int auctionActivityCfgId;
/*    */   public int turnTypeId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.auctionActivityCfgId = Integer.valueOf(rootElement.attributeValue("auctionActivityCfgId")).intValue();
/* 15 */     this.turnTypeId = Integer.valueOf(rootElement.attributeValue("turnTypeId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.auctionActivityCfgId);
/* 21 */     _os_.marshal(this.turnTypeId);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.auctionActivityCfgId = _os_.unmarshal_int();
/* 28 */     this.turnTypeId = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\confbean\SAuctionActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */