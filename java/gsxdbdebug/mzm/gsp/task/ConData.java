/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ConData implements Marshal
/*    */ {
/*    */   public int conid;
/*    */   public long param;
/*    */   public String subparam;
/*    */   
/*    */   public ConData()
/*    */   {
/* 14 */     this.subparam = "";
/*    */   }
/*    */   
/*    */   public ConData(int _conid_, long _param_, String _subparam_) {
/* 18 */     this.conid = _conid_;
/* 19 */     this.param = _param_;
/* 20 */     this.subparam = _subparam_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.conid);
/* 29 */     _os_.marshal(this.param);
/* 30 */     _os_.marshal(this.subparam, "UTF-16LE");
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     this.conid = _os_.unmarshal_int();
/* 36 */     this.param = _os_.unmarshal_long();
/* 37 */     this.subparam = _os_.unmarshal_String("UTF-16LE");
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof ConData)) {
/* 44 */       ConData _o_ = (ConData)_o1_;
/* 45 */       if (this.conid != _o_.conid) return false;
/* 46 */       if (this.param != _o_.param) return false;
/* 47 */       if (!this.subparam.equals(_o_.subparam)) return false;
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     _h_ += this.conid;
/* 56 */     _h_ += (int)this.param;
/* 57 */     _h_ += this.subparam.hashCode();
/* 58 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 62 */     StringBuilder _sb_ = new StringBuilder();
/* 63 */     _sb_.append("(");
/* 64 */     _sb_.append(this.conid).append(",");
/* 65 */     _sb_.append(this.param).append(",");
/* 66 */     _sb_.append("T").append(this.subparam.length()).append(",");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ConData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */