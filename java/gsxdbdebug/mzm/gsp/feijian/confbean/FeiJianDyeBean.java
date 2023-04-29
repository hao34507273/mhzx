/*    */ package mzm.gsp.feijian.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FeiJianDyeBean implements Marshal
/*    */ {
/*    */   public int item_id;
/*    */   public int cost_item_type;
/*    */   public int item_count;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.item_id = Integer.valueOf(rootElement.attributeValue("item_id")).intValue();
/* 16 */     this.cost_item_type = Integer.valueOf(rootElement.attributeValue("cost_item_type")).intValue();
/* 17 */     this.item_count = Integer.valueOf(rootElement.attributeValue("item_count")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.item_id);
/* 23 */     _os_.marshal(this.cost_item_type);
/* 24 */     _os_.marshal(this.item_count);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.item_id = _os_.unmarshal_int();
/* 31 */     this.cost_item_type = _os_.unmarshal_int();
/* 32 */     this.item_count = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feijian\confbean\FeiJianDyeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */