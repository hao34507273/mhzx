/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class KeJuChart
/*    */   implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String rolename;
/*    */   public int ranklevel;
/*    */   public int usetime;
/*    */   
/*    */   public KeJuChart()
/*    */   {
/* 17 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public KeJuChart(long _roleid_, String _rolename_, int _ranklevel_, int _usetime_) {
/* 21 */     this.roleid = _roleid_;
/* 22 */     this.rolename = _rolename_;
/* 23 */     this.ranklevel = _ranklevel_;
/* 24 */     this.usetime = _usetime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.roleid);
/* 33 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 34 */     _os_.marshal(this.ranklevel);
/* 35 */     _os_.marshal(this.usetime);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.roleid = _os_.unmarshal_long();
/* 41 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 42 */     this.ranklevel = _os_.unmarshal_int();
/* 43 */     this.usetime = _os_.unmarshal_int();
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof KeJuChart)) {
/* 50 */       KeJuChart _o_ = (KeJuChart)_o1_;
/* 51 */       if (this.roleid != _o_.roleid) return false;
/* 52 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 53 */       if (this.ranklevel != _o_.ranklevel) return false;
/* 54 */       if (this.usetime != _o_.usetime) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += (int)this.roleid;
/* 63 */     _h_ += this.rolename.hashCode();
/* 64 */     _h_ += this.ranklevel;
/* 65 */     _h_ += this.usetime;
/* 66 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuilder _sb_ = new StringBuilder();
/* 71 */     _sb_.append("(");
/* 72 */     _sb_.append(this.roleid).append(",");
/* 73 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 74 */     _sb_.append(this.ranklevel).append(",");
/* 75 */     _sb_.append(this.usetime).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\KeJuChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */