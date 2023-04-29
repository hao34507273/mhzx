/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ public class SSyncPetBagList
/*     */   extends __SSyncPetBagList__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590593;
/*     */   public long fightpetid;
/*     */   public long showpetid;
/*     */   public LinkedList<PetInfo> petlist;
/*     */   public int bagsize;
/*     */   public int expandcount;
/*     */   public HashMap<Integer, Integer> rememberItems;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590593;
/*     */   }
/*     */   
/*     */   public SSyncPetBagList() {
/*  31 */     this.petlist = new LinkedList();
/*  32 */     this.rememberItems = new HashMap();
/*     */   }
/*     */   
/*     */   public SSyncPetBagList(long _fightpetid_, long _showpetid_, LinkedList<PetInfo> _petlist_, int _bagsize_, int _expandcount_, HashMap<Integer, Integer> _rememberitems_) {
/*  36 */     this.fightpetid = _fightpetid_;
/*  37 */     this.showpetid = _showpetid_;
/*  38 */     this.petlist = _petlist_;
/*  39 */     this.bagsize = _bagsize_;
/*  40 */     this.expandcount = _expandcount_;
/*  41 */     this.rememberItems = _rememberitems_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     Iterator<PetInfo> i$ = this.petlist.iterator();
/*  46 */     while (i$.hasNext()) {
/*  47 */       PetInfo _v_ = (PetInfo)i$.next();
/*  48 */       if (!_v_._validator_()) {
/*  49 */         return false;
/*     */       }
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  57 */     _os_.marshal(this.fightpetid);
/*  58 */     _os_.marshal(this.showpetid);
/*  59 */     _os_.compact_uint32(this.petlist.size());
/*  60 */     Iterator<PetInfo> i$ = this.petlist.iterator();
/*  61 */     while (i$.hasNext()) {
/*  62 */       PetInfo _v_ = (PetInfo)i$.next();
/*  63 */       _os_.marshal(_v_);
/*     */     }
/*  65 */     _os_.marshal(this.bagsize);
/*  66 */     _os_.marshal(this.expandcount);
/*     */     
/*  68 */     _os_.compact_uint32(this.rememberItems.size());
/*  69 */     Iterator rm = this.rememberItems.entrySet().iterator();
/*     */     
/*  71 */     while (rm.hasNext()) {
/*  72 */       Map.Entry _e_ = (Map.Entry)rm.next();
/*  73 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  74 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException
/*     */   {
/*  81 */     this.fightpetid = _os_.unmarshal_long();
/*  82 */     this.showpetid = _os_.unmarshal_long();
/*  83 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  84 */       PetInfo _v_ = new PetInfo();
/*  85 */       _v_.unmarshal(_os_);
/*  86 */       this.petlist.add(_v_);
/*     */     }
/*  88 */     this.bagsize = _os_.unmarshal_int();
/*  89 */     this.expandcount = _os_.unmarshal_int();
/*  90 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  91 */       this.rememberItems.put(Integer.valueOf(_os_.unmarshal_int()), Integer.valueOf(_os_.unmarshal_int()));
/*     */     }
/*  93 */     if (_validator_()) {
/*  94 */       return _os_;
/*     */     }
/*  96 */     throw new VerifyError("validator failed");
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_)
/*     */   {
/* 101 */     if (_o1_ == this) {
/* 102 */       return true;
/*     */     }
/* 104 */     if (!(_o1_ instanceof SSyncPetBagList)) {
/* 105 */       return false;
/*     */     }
/* 107 */     SSyncPetBagList _o_ = (SSyncPetBagList)_o1_;
/* 108 */     return (this.rememberItems.equals(_o_.rememberItems)) && (this.fightpetid == _o_.fightpetid) && (this.showpetid == _o_.showpetid) && (this.petlist.equals(_o_.petlist)) && (this.bagsize == _o_.bagsize) && (this.expandcount == _o_.expandcount);
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 113 */     int _h_ = 0 + (int)this.fightpetid;
/* 114 */     return _h_ + (int)this.showpetid + this.petlist.hashCode() + this.bagsize + this.expandcount + this.rememberItems.hashCode();
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 119 */     StringBuilder _sb_ = new StringBuilder();
/* 120 */     _sb_.append("(");
/* 121 */     _sb_.append(this.fightpetid).append(",");
/* 122 */     _sb_.append(this.showpetid).append(",");
/* 123 */     _sb_.append(this.petlist).append(",");
/* 124 */     _sb_.append(this.bagsize).append(",");
/* 125 */     _sb_.append(this.expandcount).append(",");
/* 126 */     _sb_.append(this.rememberItems).append(",");
/* 127 */     _sb_.append(")");
/* 128 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SSyncPetBagList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */