/*    */ package mzm.gsp.planttree.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SpecialStateInfo implements Marshal
/*    */ {
/*    */   public int special_state_index;
/*    */   public String special_state_name;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.special_state_index = Integer.valueOf(rootElement.attributeValue("special_state_index")).intValue();
/* 15 */     this.special_state_name = rootElement.attributeValue("special_state_name");
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.special_state_index);
/* 21 */     _os_.marshal(this.special_state_name, "UTF-8");
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.special_state_index = _os_.unmarshal_int();
/* 28 */     this.special_state_name = _os_.unmarshal_String("UTF-8");
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\confbean\SpecialStateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */