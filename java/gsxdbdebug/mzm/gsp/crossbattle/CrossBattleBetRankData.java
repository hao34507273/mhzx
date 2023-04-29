/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class CrossBattleBetRankData implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public long roleid;
/*    */   public Octets name;
/*    */   public int occupation;
/*    */   public long profit;
/*    */   public int timestamp;
/*    */   
/*    */   public CrossBattleBetRankData()
/*    */   {
/* 19 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public CrossBattleBetRankData(int _rank_, long _roleid_, Octets _name_, int _occupation_, long _profit_, int _timestamp_) {
/* 23 */     this.rank = _rank_;
/* 24 */     this.roleid = _roleid_;
/* 25 */     this.name = _name_;
/* 26 */     this.occupation = _occupation_;
/* 27 */     this.profit = _profit_;
/* 28 */     this.timestamp = _timestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.rank);
/* 37 */     _os_.marshal(this.roleid);
/* 38 */     _os_.marshal(this.name);
/* 39 */     _os_.marshal(this.occupation);
/* 40 */     _os_.marshal(this.profit);
/* 41 */     _os_.marshal(this.timestamp);
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     this.rank = _os_.unmarshal_int();
/* 47 */     this.roleid = _os_.unmarshal_long();
/* 48 */     this.name = _os_.unmarshal_Octets();
/* 49 */     this.occupation = _os_.unmarshal_int();
/* 50 */     this.profit = _os_.unmarshal_long();
/* 51 */     this.timestamp = _os_.unmarshal_int();
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof CrossBattleBetRankData)) {
/* 58 */       CrossBattleBetRankData _o_ = (CrossBattleBetRankData)_o1_;
/* 59 */       if (this.rank != _o_.rank) return false;
/* 60 */       if (this.roleid != _o_.roleid) return false;
/* 61 */       if (!this.name.equals(_o_.name)) return false;
/* 62 */       if (this.occupation != _o_.occupation) return false;
/* 63 */       if (this.profit != _o_.profit) return false;
/* 64 */       if (this.timestamp != _o_.timestamp) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.rank;
/* 73 */     _h_ += (int)this.roleid;
/* 74 */     _h_ += this.name.hashCode();
/* 75 */     _h_ += this.occupation;
/* 76 */     _h_ += (int)this.profit;
/* 77 */     _h_ += this.timestamp;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.rank).append(",");
/* 85 */     _sb_.append(this.roleid).append(",");
/* 86 */     _sb_.append("B").append(this.name.size()).append(",");
/* 87 */     _sb_.append(this.occupation).append(",");
/* 88 */     _sb_.append(this.profit).append(",");
/* 89 */     _sb_.append(this.timestamp).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattleBetRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */