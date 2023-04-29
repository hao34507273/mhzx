/*    */ package mzm.gsp.luckystar.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ConditionValueBean implements Marshal
/*    */ {
/*    */   public int left_value;
/*    */   public int right_value;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.left_value = Integer.valueOf(rootElement.attributeValue("left_value")).intValue();
/* 15 */     this.right_value = Integer.valueOf(rootElement.attributeValue("right_value")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.left_value);
/* 21 */     _os_.marshal(this.right_value);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.left_value = _os_.unmarshal_int();
/* 28 */     this.right_value = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\confbean\ConditionValueBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */