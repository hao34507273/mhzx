/*    */ package mzm.gsp.jingji;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleJingjiRankData implements Marshal
/*    */ {
/*    */   public int no;
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int phase;
/*    */   public int winpoint;
/*    */   
/*    */   public RoleJingjiRankData()
/*    */   {
/* 16 */     this.name = "";
/*    */   }
/*    */   
/*    */   public RoleJingjiRankData(int _no_, long _roleid_, String _name_, int _phase_, int _winpoint_) {
/* 20 */     this.no = _no_;
/* 21 */     this.roleid = _roleid_;
/* 22 */     this.name = _name_;
/* 23 */     this.phase = _phase_;
/* 24 */     this.winpoint = _winpoint_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.no);
/* 33 */     _os_.marshal(this.roleid);
/* 34 */     _os_.marshal(this.name, "UTF-16LE");
/* 35 */     _os_.marshal(this.phase);
/* 36 */     _os_.marshal(this.winpoint);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.no = _os_.unmarshal_int();
/* 42 */     this.roleid = _os_.unmarshal_long();
/* 43 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 44 */     this.phase = _os_.unmarshal_int();
/* 45 */     this.winpoint = _os_.unmarshal_int();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof RoleJingjiRankData)) {
/* 52 */       RoleJingjiRankData _o_ = (RoleJingjiRankData)_o1_;
/* 53 */       if (this.no != _o_.no) return false;
/* 54 */       if (this.roleid != _o_.roleid) return false;
/* 55 */       if (!this.name.equals(_o_.name)) return false;
/* 56 */       if (this.phase != _o_.phase) return false;
/* 57 */       if (this.winpoint != _o_.winpoint) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.no;
/* 66 */     _h_ += (int)this.roleid;
/* 67 */     _h_ += this.name.hashCode();
/* 68 */     _h_ += this.phase;
/* 69 */     _h_ += this.winpoint;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.no).append(",");
/* 77 */     _sb_.append(this.roleid).append(",");
/* 78 */     _sb_.append("T").append(this.name.length()).append(",");
/* 79 */     _sb_.append(this.phase).append(",");
/* 80 */     _sb_.append(this.winpoint).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\RoleJingjiRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */