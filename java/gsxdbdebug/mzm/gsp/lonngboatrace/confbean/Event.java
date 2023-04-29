/*    */ package mzm.gsp.lonngboatrace.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class Event implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int weight;
/*    */   public double delta;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 16 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/* 17 */     this.delta = Double.valueOf(rootElement.attributeValue("delta")).doubleValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.id);
/* 23 */     _os_.marshal(this.weight);
/* 24 */     _os_.marshal(this.delta);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.id = _os_.unmarshal_int();
/* 31 */     this.weight = _os_.unmarshal_int();
/* 32 */     this.delta = _os_.unmarshal_float();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\confbean\Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */