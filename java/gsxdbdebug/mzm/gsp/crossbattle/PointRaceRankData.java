/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class PointRaceRankData implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int zoneid;
/*    */   public Octets corps_name;
/*    */   public int icon;
/*    */   public int rank;
/*    */   public int point;
/*    */   
/*    */   public PointRaceRankData()
/*    */   {
/* 16 */     this.corps_name = new Octets();
/*    */   }
/*    */   
/*    */   public PointRaceRankData(int _zoneid_, Octets _corps_name_, int _icon_, int _rank_, int _point_) {
/* 20 */     this.zoneid = _zoneid_;
/* 21 */     this.corps_name = _corps_name_;
/* 22 */     this.icon = _icon_;
/* 23 */     this.rank = _rank_;
/* 24 */     this.point = _point_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.zoneid);
/* 33 */     _os_.marshal(this.corps_name);
/* 34 */     _os_.marshal(this.icon);
/* 35 */     _os_.marshal(this.rank);
/* 36 */     _os_.marshal(this.point);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.zoneid = _os_.unmarshal_int();
/* 42 */     this.corps_name = _os_.unmarshal_Octets();
/* 43 */     this.icon = _os_.unmarshal_int();
/* 44 */     this.rank = _os_.unmarshal_int();
/* 45 */     this.point = _os_.unmarshal_int();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof PointRaceRankData)) {
/* 52 */       PointRaceRankData _o_ = (PointRaceRankData)_o1_;
/* 53 */       if (this.zoneid != _o_.zoneid) return false;
/* 54 */       if (!this.corps_name.equals(_o_.corps_name)) return false;
/* 55 */       if (this.icon != _o_.icon) return false;
/* 56 */       if (this.rank != _o_.rank) return false;
/* 57 */       if (this.point != _o_.point) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.zoneid;
/* 66 */     _h_ += this.corps_name.hashCode();
/* 67 */     _h_ += this.icon;
/* 68 */     _h_ += this.rank;
/* 69 */     _h_ += this.point;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.zoneid).append(",");
/* 77 */     _sb_.append("B").append(this.corps_name.size()).append(",");
/* 78 */     _sb_.append(this.icon).append(",");
/* 79 */     _sb_.append(this.rank).append(",");
/* 80 */     _sb_.append(this.point).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\PointRaceRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */