/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RankAwardMailItemBean implements Marshal
/*    */ {
/*    */   public int award_item_id;
/*    */   public int award_item_num;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.award_item_id = Integer.valueOf(rootElement.attributeValue("award_item_id")).intValue();
/* 15 */     this.award_item_num = Integer.valueOf(rootElement.attributeValue("award_item_num")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.award_item_id);
/* 21 */     _os_.marshal(this.award_item_num);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.award_item_id = _os_.unmarshal_int();
/* 28 */     this.award_item_num = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\RankAwardMailItemBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */