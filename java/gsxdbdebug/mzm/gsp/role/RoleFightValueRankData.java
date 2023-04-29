/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleFightValueRankData
/*    */   implements Marshal
/*    */ {
/*    */   public int no;
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int occupationid;
/*    */   public int fightvalue;
/*    */   public int step;
/*    */   
/*    */   public RoleFightValueRankData()
/*    */   {
/* 19 */     this.name = "";
/*    */   }
/*    */   
/*    */   public RoleFightValueRankData(int _no_, long _roleid_, String _name_, int _occupationid_, int _fightvalue_, int _step_) {
/* 23 */     this.no = _no_;
/* 24 */     this.roleid = _roleid_;
/* 25 */     this.name = _name_;
/* 26 */     this.occupationid = _occupationid_;
/* 27 */     this.fightvalue = _fightvalue_;
/* 28 */     this.step = _step_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.no);
/* 37 */     _os_.marshal(this.roleid);
/* 38 */     _os_.marshal(this.name, "UTF-16LE");
/* 39 */     _os_.marshal(this.occupationid);
/* 40 */     _os_.marshal(this.fightvalue);
/* 41 */     _os_.marshal(this.step);
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     this.no = _os_.unmarshal_int();
/* 47 */     this.roleid = _os_.unmarshal_long();
/* 48 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 49 */     this.occupationid = _os_.unmarshal_int();
/* 50 */     this.fightvalue = _os_.unmarshal_int();
/* 51 */     this.step = _os_.unmarshal_int();
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof RoleFightValueRankData)) {
/* 58 */       RoleFightValueRankData _o_ = (RoleFightValueRankData)_o1_;
/* 59 */       if (this.no != _o_.no) return false;
/* 60 */       if (this.roleid != _o_.roleid) return false;
/* 61 */       if (!this.name.equals(_o_.name)) return false;
/* 62 */       if (this.occupationid != _o_.occupationid) return false;
/* 63 */       if (this.fightvalue != _o_.fightvalue) return false;
/* 64 */       if (this.step != _o_.step) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.no;
/* 73 */     _h_ += (int)this.roleid;
/* 74 */     _h_ += this.name.hashCode();
/* 75 */     _h_ += this.occupationid;
/* 76 */     _h_ += this.fightvalue;
/* 77 */     _h_ += this.step;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.no).append(",");
/* 85 */     _sb_.append(this.roleid).append(",");
/* 86 */     _sb_.append("T").append(this.name.length()).append(",");
/* 87 */     _sb_.append(this.occupationid).append(",");
/* 88 */     _sb_.append(this.fightvalue).append(",");
/* 89 */     _sb_.append(this.step).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\RoleFightValueRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */