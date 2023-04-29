/*    */ package mzm.gsp.skill.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class CostType2Formulaid implements Marshal
/*    */ {
/*    */   public int costType;
/*    */   public int formulaid;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.costType = Integer.valueOf(rootElement.attributeValue("costType")).intValue();
/* 15 */     this.formulaid = Integer.valueOf(rootElement.attributeValue("formulaid")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.costType);
/* 21 */     _os_.marshal(this.formulaid);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.costType = _os_.unmarshal_int();
/* 28 */     this.formulaid = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\CostType2Formulaid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */