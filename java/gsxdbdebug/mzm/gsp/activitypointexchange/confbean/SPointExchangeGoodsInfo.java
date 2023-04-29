/*    */ package mzm.gsp.activitypointexchange.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SPointExchangeGoodsInfo implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int fixAwardId;
/*    */   public int exchangeMaxCount;
/*    */   public int tokenCount;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 17 */     this.fixAwardId = Integer.valueOf(rootElement.attributeValue("fixAwardId")).intValue();
/* 18 */     this.exchangeMaxCount = Integer.valueOf(rootElement.attributeValue("exchangeMaxCount")).intValue();
/* 19 */     this.tokenCount = Integer.valueOf(rootElement.attributeValue("tokenCount")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.id);
/* 25 */     _os_.marshal(this.fixAwardId);
/* 26 */     _os_.marshal(this.exchangeMaxCount);
/* 27 */     _os_.marshal(this.tokenCount);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.id = _os_.unmarshal_int();
/* 34 */     this.fixAwardId = _os_.unmarshal_int();
/* 35 */     this.exchangeMaxCount = _os_.unmarshal_int();
/* 36 */     this.tokenCount = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\confbean\SPointExchangeGoodsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */