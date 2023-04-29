/*    */ package mzm.gsp.gang.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ApplyOldOnlineWeight implements Marshal
/*    */ {
/*    */   public int online;
/*    */   public int weight;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.online = Integer.valueOf(rootElement.attributeValue("online")).intValue();
/* 15 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.online);
/* 21 */     _os_.marshal(this.weight);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.online = _os_.unmarshal_int();
/* 28 */     this.weight = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\confbean\ApplyOldOnlineWeight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */