/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class YaoDianInfo implements Marshal
/*    */ {
/*    */   public int level;
/*    */   public int levelupendtime;
/*    */   public ArrayList<YaoCaiShopItem> shopitemlist;
/*    */   
/*    */   public YaoDianInfo()
/*    */   {
/* 16 */     this.shopitemlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public YaoDianInfo(int _level_, int _levelupendtime_, ArrayList<YaoCaiShopItem> _shopitemlist_) {
/* 20 */     this.level = _level_;
/* 21 */     this.levelupendtime = _levelupendtime_;
/* 22 */     this.shopitemlist = _shopitemlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     for (YaoCaiShopItem _v_ : this.shopitemlist)
/* 27 */       if (!_v_._validator_()) return false;
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.level);
/* 33 */     _os_.marshal(this.levelupendtime);
/* 34 */     _os_.compact_uint32(this.shopitemlist.size());
/* 35 */     for (YaoCaiShopItem _v_ : this.shopitemlist) {
/* 36 */       _os_.marshal(_v_);
/*    */     }
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.level = _os_.unmarshal_int();
/* 43 */     this.levelupendtime = _os_.unmarshal_int();
/* 44 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 45 */       YaoCaiShopItem _v_ = new YaoCaiShopItem();
/* 46 */       _v_.unmarshal(_os_);
/* 47 */       this.shopitemlist.add(_v_);
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof YaoDianInfo)) {
/* 55 */       YaoDianInfo _o_ = (YaoDianInfo)_o1_;
/* 56 */       if (this.level != _o_.level) return false;
/* 57 */       if (this.levelupendtime != _o_.levelupendtime) return false;
/* 58 */       if (!this.shopitemlist.equals(_o_.shopitemlist)) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += this.level;
/* 67 */     _h_ += this.levelupendtime;
/* 68 */     _h_ += this.shopitemlist.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.level).append(",");
/* 76 */     _sb_.append(this.levelupendtime).append(",");
/* 77 */     _sb_.append(this.shopitemlist).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\YaoDianInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */