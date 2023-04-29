/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class MasterRankData
/*    */   implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int apprenticesize;
/*    */   public int occupationid;
/*    */   
/*    */   public MasterRankData()
/*    */   {
/* 18 */     this.name = "";
/*    */   }
/*    */   
/*    */   public MasterRankData(int _rank_, long _roleid_, String _name_, int _apprenticesize_, int _occupationid_) {
/* 22 */     this.rank = _rank_;
/* 23 */     this.roleid = _roleid_;
/* 24 */     this.name = _name_;
/* 25 */     this.apprenticesize = _apprenticesize_;
/* 26 */     this.occupationid = _occupationid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.rank);
/* 35 */     _os_.marshal(this.roleid);
/* 36 */     _os_.marshal(this.name, "UTF-16LE");
/* 37 */     _os_.marshal(this.apprenticesize);
/* 38 */     _os_.marshal(this.occupationid);
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 43 */     this.rank = _os_.unmarshal_int();
/* 44 */     this.roleid = _os_.unmarshal_long();
/* 45 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 46 */     this.apprenticesize = _os_.unmarshal_int();
/* 47 */     this.occupationid = _os_.unmarshal_int();
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof MasterRankData)) {
/* 54 */       MasterRankData _o_ = (MasterRankData)_o1_;
/* 55 */       if (this.rank != _o_.rank) return false;
/* 56 */       if (this.roleid != _o_.roleid) return false;
/* 57 */       if (!this.name.equals(_o_.name)) return false;
/* 58 */       if (this.apprenticesize != _o_.apprenticesize) return false;
/* 59 */       if (this.occupationid != _o_.occupationid) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.rank;
/* 68 */     _h_ += (int)this.roleid;
/* 69 */     _h_ += this.name.hashCode();
/* 70 */     _h_ += this.apprenticesize;
/* 71 */     _h_ += this.occupationid;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.rank).append(",");
/* 79 */     _sb_.append(this.roleid).append(",");
/* 80 */     _sb_.append("T").append(this.name.length()).append(",");
/* 81 */     _sb_.append(this.apprenticesize).append(",");
/* 82 */     _sb_.append(this.occupationid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\MasterRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */