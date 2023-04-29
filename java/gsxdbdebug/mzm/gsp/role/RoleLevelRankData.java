/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleLevelRankData implements Marshal
/*    */ {
/*    */   public int no;
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int occupationid;
/*    */   public int level;
/*    */   public int step;
/*    */   
/*    */   public RoleLevelRankData()
/*    */   {
/* 17 */     this.name = "";
/*    */   }
/*    */   
/*    */   public RoleLevelRankData(int _no_, long _roleid_, String _name_, int _occupationid_, int _level_, int _step_) {
/* 21 */     this.no = _no_;
/* 22 */     this.roleid = _roleid_;
/* 23 */     this.name = _name_;
/* 24 */     this.occupationid = _occupationid_;
/* 25 */     this.level = _level_;
/* 26 */     this.step = _step_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.no);
/* 35 */     _os_.marshal(this.roleid);
/* 36 */     _os_.marshal(this.name, "UTF-16LE");
/* 37 */     _os_.marshal(this.occupationid);
/* 38 */     _os_.marshal(this.level);
/* 39 */     _os_.marshal(this.step);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.no = _os_.unmarshal_int();
/* 45 */     this.roleid = _os_.unmarshal_long();
/* 46 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 47 */     this.occupationid = _os_.unmarshal_int();
/* 48 */     this.level = _os_.unmarshal_int();
/* 49 */     this.step = _os_.unmarshal_int();
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof RoleLevelRankData)) {
/* 56 */       RoleLevelRankData _o_ = (RoleLevelRankData)_o1_;
/* 57 */       if (this.no != _o_.no) return false;
/* 58 */       if (this.roleid != _o_.roleid) return false;
/* 59 */       if (!this.name.equals(_o_.name)) return false;
/* 60 */       if (this.occupationid != _o_.occupationid) return false;
/* 61 */       if (this.level != _o_.level) return false;
/* 62 */       if (this.step != _o_.step) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.no;
/* 71 */     _h_ += (int)this.roleid;
/* 72 */     _h_ += this.name.hashCode();
/* 73 */     _h_ += this.occupationid;
/* 74 */     _h_ += this.level;
/* 75 */     _h_ += this.step;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.no).append(",");
/* 83 */     _sb_.append(this.roleid).append(",");
/* 84 */     _sb_.append("T").append(this.name.length()).append(",");
/* 85 */     _sb_.append(this.occupationid).append(",");
/* 86 */     _sb_.append(this.level).append(",");
/* 87 */     _sb_.append(this.step).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\RoleLevelRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */