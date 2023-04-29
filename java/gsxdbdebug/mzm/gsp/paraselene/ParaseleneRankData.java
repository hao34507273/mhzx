/*    */ package mzm.gsp.paraselene;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ParaseleneRankData implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int occupationid;
/*    */   public int seconds;
/*    */   
/*    */   public ParaseleneRankData()
/*    */   {
/* 16 */     this.name = "";
/*    */   }
/*    */   
/*    */   public ParaseleneRankData(int _rank_, long _roleid_, String _name_, int _occupationid_, int _seconds_) {
/* 20 */     this.rank = _rank_;
/* 21 */     this.roleid = _roleid_;
/* 22 */     this.name = _name_;
/* 23 */     this.occupationid = _occupationid_;
/* 24 */     this.seconds = _seconds_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.rank);
/* 33 */     _os_.marshal(this.roleid);
/* 34 */     _os_.marshal(this.name, "UTF-16LE");
/* 35 */     _os_.marshal(this.occupationid);
/* 36 */     _os_.marshal(this.seconds);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.rank = _os_.unmarshal_int();
/* 42 */     this.roleid = _os_.unmarshal_long();
/* 43 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 44 */     this.occupationid = _os_.unmarshal_int();
/* 45 */     this.seconds = _os_.unmarshal_int();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof ParaseleneRankData)) {
/* 52 */       ParaseleneRankData _o_ = (ParaseleneRankData)_o1_;
/* 53 */       if (this.rank != _o_.rank) return false;
/* 54 */       if (this.roleid != _o_.roleid) return false;
/* 55 */       if (!this.name.equals(_o_.name)) return false;
/* 56 */       if (this.occupationid != _o_.occupationid) return false;
/* 57 */       if (this.seconds != _o_.seconds) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.rank;
/* 66 */     _h_ += (int)this.roleid;
/* 67 */     _h_ += this.name.hashCode();
/* 68 */     _h_ += this.occupationid;
/* 69 */     _h_ += this.seconds;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.rank).append(",");
/* 77 */     _sb_.append(this.roleid).append(",");
/* 78 */     _sb_.append("T").append(this.name.length()).append(",");
/* 79 */     _sb_.append(this.occupationid).append(",");
/* 80 */     _sb_.append(this.seconds).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\ParaseleneRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */