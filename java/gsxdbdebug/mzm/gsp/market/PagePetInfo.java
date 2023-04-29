/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class PagePetInfo implements Marshal
/*    */ {
/*    */   public int pageindex;
/*    */   public int totalpagenum;
/*    */   public int subid;
/*    */   public ArrayList<MarketPet> marketpetlist;
/*    */   
/*    */   public PagePetInfo()
/*    */   {
/* 17 */     this.marketpetlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public PagePetInfo(int _pageindex_, int _totalpagenum_, int _subid_, ArrayList<MarketPet> _marketpetlist_) {
/* 21 */     this.pageindex = _pageindex_;
/* 22 */     this.totalpagenum = _totalpagenum_;
/* 23 */     this.subid = _subid_;
/* 24 */     this.marketpetlist = _marketpetlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     for (MarketPet _v_ : this.marketpetlist)
/* 29 */       if (!_v_._validator_()) return false;
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.pageindex);
/* 35 */     _os_.marshal(this.totalpagenum);
/* 36 */     _os_.marshal(this.subid);
/* 37 */     _os_.compact_uint32(this.marketpetlist.size());
/* 38 */     for (MarketPet _v_ : this.marketpetlist) {
/* 39 */       _os_.marshal(_v_);
/*    */     }
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     this.pageindex = _os_.unmarshal_int();
/* 46 */     this.totalpagenum = _os_.unmarshal_int();
/* 47 */     this.subid = _os_.unmarshal_int();
/* 48 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 49 */       MarketPet _v_ = new MarketPet();
/* 50 */       _v_.unmarshal(_os_);
/* 51 */       this.marketpetlist.add(_v_);
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof PagePetInfo)) {
/* 59 */       PagePetInfo _o_ = (PagePetInfo)_o1_;
/* 60 */       if (this.pageindex != _o_.pageindex) return false;
/* 61 */       if (this.totalpagenum != _o_.totalpagenum) return false;
/* 62 */       if (this.subid != _o_.subid) return false;
/* 63 */       if (!this.marketpetlist.equals(_o_.marketpetlist)) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.pageindex;
/* 72 */     _h_ += this.totalpagenum;
/* 73 */     _h_ += this.subid;
/* 74 */     _h_ += this.marketpetlist.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.pageindex).append(",");
/* 82 */     _sb_.append(this.totalpagenum).append(",");
/* 83 */     _sb_.append(this.subid).append(",");
/* 84 */     _sb_.append(this.marketpetlist).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\PagePetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */