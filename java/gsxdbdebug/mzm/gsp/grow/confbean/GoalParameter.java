/*    */ package mzm.gsp.grow.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class GoalParameter implements Marshal
/*    */ {
/*    */   public int parameter;
/*    */   public int type;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.parameter = Integer.valueOf(rootElement.attributeValue("parameter")).intValue();
/* 15 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.parameter);
/* 21 */     _os_.marshal(this.type);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.parameter = _os_.unmarshal_int();
/* 28 */     this.type = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\confbean\GoalParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */