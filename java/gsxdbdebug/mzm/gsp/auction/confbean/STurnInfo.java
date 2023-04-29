/*    */ package mzm.gsp.auction.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class STurnInfo implements Marshal
/*    */ {
/*    */   public int turnTimeId;
/*    */   public int itemSumTypeId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.turnTimeId = Integer.valueOf(rootElement.attributeValue("turnTimeId")).intValue();
/* 15 */     this.itemSumTypeId = Integer.valueOf(rootElement.attributeValue("itemSumTypeId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.turnTimeId);
/* 21 */     _os_.marshal(this.itemSumTypeId);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.turnTimeId = _os_.unmarshal_int();
/* 28 */     this.itemSumTypeId = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\confbean\STurnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */