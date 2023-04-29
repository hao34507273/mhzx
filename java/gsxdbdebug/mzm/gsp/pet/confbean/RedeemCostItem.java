/*    */ package mzm.gsp.pet.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RedeemCostItem implements Marshal
/*    */ {
/*    */   public int itemTypeId;
/*    */   public int itemNum;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.itemTypeId = Integer.valueOf(rootElement.attributeValue("itemTypeId")).intValue();
/* 15 */     this.itemNum = Integer.valueOf(rootElement.attributeValue("itemNum")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.itemTypeId);
/* 21 */     _os_.marshal(this.itemNum);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.itemTypeId = _os_.unmarshal_int();
/* 28 */     this.itemNum = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\RedeemCostItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */