/*    */ package mzm.gsp.lonngboatrace.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class Command implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int commandType;
/*    */   public String commandName;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 16 */     this.commandType = Integer.valueOf(rootElement.attributeValue("commandType")).intValue();
/* 17 */     this.commandName = rootElement.attributeValue("commandName");
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.id);
/* 23 */     _os_.marshal(this.commandType);
/* 24 */     _os_.marshal(this.commandName, "UTF-8");
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.id = _os_.unmarshal_int();
/* 31 */     this.commandType = _os_.unmarshal_int();
/* 32 */     this.commandName = _os_.unmarshal_String("UTF-8");
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\confbean\Command.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */