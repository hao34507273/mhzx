/*    */ package mzm.gsp.crosscompete;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class CompeteResultFaction
/*    */   implements Marshal
/*    */ {
/*    */   public static final int SELF_SERVER_FALSE = 0;
/*    */   public static final int SELF_SERVER_TRUE = 1;
/*    */   public long factionid;
/*    */   public String name;
/*    */   public int self_server;
/*    */   
/*    */   public CompeteResultFaction()
/*    */   {
/* 19 */     this.name = "";
/*    */   }
/*    */   
/*    */   public CompeteResultFaction(long _factionid_, String _name_, int _self_server_) {
/* 23 */     this.factionid = _factionid_;
/* 24 */     this.name = _name_;
/* 25 */     this.self_server = _self_server_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.factionid);
/* 34 */     _os_.marshal(this.name, "UTF-16LE");
/* 35 */     _os_.marshal(this.self_server);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.factionid = _os_.unmarshal_long();
/* 41 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 42 */     this.self_server = _os_.unmarshal_int();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof CompeteResultFaction)) {
/* 49 */       CompeteResultFaction _o_ = (CompeteResultFaction)_o1_;
/* 50 */       if (this.factionid != _o_.factionid) return false;
/* 51 */       if (!this.name.equals(_o_.name)) return false;
/* 52 */       if (this.self_server != _o_.self_server) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += (int)this.factionid;
/* 61 */     _h_ += this.name.hashCode();
/* 62 */     _h_ += this.self_server;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.factionid).append(",");
/* 70 */     _sb_.append("T").append(this.name.length()).append(",");
/* 71 */     _sb_.append(this.self_server).append(",");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\CompeteResultFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */