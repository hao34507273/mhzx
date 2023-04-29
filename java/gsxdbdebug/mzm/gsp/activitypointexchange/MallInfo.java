/*    */ package mzm.gsp.activitypointexchange;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class MallInfo
/*    */   implements Marshal
/*    */ {
/*    */   public long pointcount;
/*    */   public ExchangeCountInfo exchangecountinfo;
/*    */   public ManualRefreshCountInfo manualrefreshcountinfo;
/*    */   public SoldOutInfo soldoutinfo;
/*    */   
/*    */   public MallInfo()
/*    */   {
/* 17 */     this.exchangecountinfo = new ExchangeCountInfo();
/* 18 */     this.manualrefreshcountinfo = new ManualRefreshCountInfo();
/* 19 */     this.soldoutinfo = new SoldOutInfo();
/*    */   }
/*    */   
/*    */   public MallInfo(long _pointcount_, ExchangeCountInfo _exchangecountinfo_, ManualRefreshCountInfo _manualrefreshcountinfo_, SoldOutInfo _soldoutinfo_) {
/* 23 */     this.pointcount = _pointcount_;
/* 24 */     this.exchangecountinfo = _exchangecountinfo_;
/* 25 */     this.manualrefreshcountinfo = _manualrefreshcountinfo_;
/* 26 */     this.soldoutinfo = _soldoutinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     if (!this.exchangecountinfo._validator_()) return false;
/* 31 */     if (!this.manualrefreshcountinfo._validator_()) return false;
/* 32 */     if (!this.soldoutinfo._validator_()) return false;
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.pointcount);
/* 38 */     _os_.marshal(this.exchangecountinfo);
/* 39 */     _os_.marshal(this.manualrefreshcountinfo);
/* 40 */     _os_.marshal(this.soldoutinfo);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     this.pointcount = _os_.unmarshal_long();
/* 46 */     this.exchangecountinfo.unmarshal(_os_);
/* 47 */     this.manualrefreshcountinfo.unmarshal(_os_);
/* 48 */     this.soldoutinfo.unmarshal(_os_);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof MallInfo)) {
/* 55 */       MallInfo _o_ = (MallInfo)_o1_;
/* 56 */       if (this.pointcount != _o_.pointcount) return false;
/* 57 */       if (!this.exchangecountinfo.equals(_o_.exchangecountinfo)) return false;
/* 58 */       if (!this.manualrefreshcountinfo.equals(_o_.manualrefreshcountinfo)) return false;
/* 59 */       if (!this.soldoutinfo.equals(_o_.soldoutinfo)) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += (int)this.pointcount;
/* 68 */     _h_ += this.exchangecountinfo.hashCode();
/* 69 */     _h_ += this.manualrefreshcountinfo.hashCode();
/* 70 */     _h_ += this.soldoutinfo.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.pointcount).append(",");
/* 78 */     _sb_.append(this.exchangecountinfo).append(",");
/* 79 */     _sb_.append(this.manualrefreshcountinfo).append(",");
/* 80 */     _sb_.append(this.soldoutinfo).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\MallInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */