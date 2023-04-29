/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class DisplayItemList extends XBean implements xbean.DisplayItemList
/*     */ {
/*     */   private long freshtime;
/*     */   private ArrayList<xbean.DisplayItem> displayitemlist;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.freshtime = 0L;
/*  21 */     this.displayitemlist.clear();
/*     */   }
/*     */   
/*     */   DisplayItemList(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.displayitemlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public DisplayItemList()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public DisplayItemList(DisplayItemList _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   DisplayItemList(xbean.DisplayItemList _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof DisplayItemList)) { assign((DisplayItemList)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(DisplayItemList _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.freshtime = _o_.freshtime;
/*  53 */     this.displayitemlist = new ArrayList();
/*  54 */     for (xbean.DisplayItem _v_ : _o_.displayitemlist) {
/*  55 */       this.displayitemlist.add(new DisplayItem(_v_, this, "displayitemlist"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  60 */     this.freshtime = _o_.freshtime;
/*  61 */     this.displayitemlist = new ArrayList();
/*  62 */     for (xbean.DisplayItem _v_ : _o_.displayitemlist) {
/*  63 */       this.displayitemlist.add(new DisplayItem(_v_, this, "displayitemlist"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.freshtime);
/*  71 */     _os_.compact_uint32(this.displayitemlist.size());
/*  72 */     for (xbean.DisplayItem _v_ : this.displayitemlist)
/*     */     {
/*  74 */       _v_.marshal(_os_);
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.freshtime = _os_.unmarshal_long();
/*  84 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  86 */       xbean.DisplayItem _v_ = new DisplayItem(0, this, "displayitemlist");
/*  87 */       _v_.unmarshal(_os_);
/*  88 */       this.displayitemlist.add(_v_);
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt64Size(1, this.freshtime);
/*  99 */     for (xbean.DisplayItem _v_ : this.displayitemlist)
/*     */     {
/* 101 */       _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*     */     }
/* 103 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       _output_.writeInt64(1, this.freshtime);
/* 113 */       for (xbean.DisplayItem _v_ : this.displayitemlist)
/*     */       {
/* 115 */         _output_.writeMessage(2, _v_);
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 120 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 122 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       boolean done = false;
/* 132 */       while (!done)
/*     */       {
/* 134 */         int tag = _input_.readTag();
/* 135 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 139 */           done = true;
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 144 */           this.freshtime = _input_.readInt64();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 149 */           xbean.DisplayItem _v_ = new DisplayItem(0, this, "displayitemlist");
/* 150 */           _input_.readMessage(_v_);
/* 151 */           this.displayitemlist.add(_v_);
/* 152 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 156 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 158 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 167 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 171 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 173 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DisplayItemList copy()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new DisplayItemList(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DisplayItemList toData()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DisplayItemList toBean()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new DisplayItemList(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DisplayItemList toDataIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DisplayItemList toBeanIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getFreshtime()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.freshtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.DisplayItem> getDisplayitemlist()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return xdb.Logs.logList(new LogKey(this, "displayitemlist"), this.displayitemlist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.DisplayItem> getDisplayitemlistAsData()
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/*     */     
/* 237 */     DisplayItemList _o_ = this;
/* 238 */     List<xbean.DisplayItem> displayitemlist = new ArrayList();
/* 239 */     for (xbean.DisplayItem _v_ : _o_.displayitemlist)
/* 240 */       displayitemlist.add(new DisplayItem.Data(_v_));
/* 241 */     return displayitemlist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFreshtime(long _v_)
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     xdb.Logs.logIf(new LogKey(this, "freshtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 253 */         new xdb.logs.LogLong(this, DisplayItemList.this.freshtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 257 */             DisplayItemList.this.freshtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 261 */     });
/* 262 */     this.freshtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     DisplayItemList _o_ = null;
/* 270 */     if ((_o1_ instanceof DisplayItemList)) { _o_ = (DisplayItemList)_o1_;
/* 271 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 272 */       return false;
/* 273 */     if (this.freshtime != _o_.freshtime) return false;
/* 274 */     if (!this.displayitemlist.equals(_o_.displayitemlist)) return false;
/* 275 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     int _h_ = 0;
/* 283 */     _h_ = (int)(_h_ + this.freshtime);
/* 284 */     _h_ += this.displayitemlist.hashCode();
/* 285 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     StringBuilder _sb_ = new StringBuilder();
/* 293 */     _sb_.append("(");
/* 294 */     _sb_.append(this.freshtime);
/* 295 */     _sb_.append(",");
/* 296 */     _sb_.append(this.displayitemlist);
/* 297 */     _sb_.append(")");
/* 298 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 304 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 305 */     lb.add(new xdb.logs.ListenableChanged().setVarName("freshtime"));
/* 306 */     lb.add(new xdb.logs.ListenableChanged().setVarName("displayitemlist"));
/* 307 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.DisplayItemList {
/*     */     private Const() {}
/*     */     
/*     */     DisplayItemList nThis() {
/* 314 */       return DisplayItemList.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 320 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DisplayItemList copy()
/*     */     {
/* 326 */       return DisplayItemList.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DisplayItemList toData()
/*     */     {
/* 332 */       return DisplayItemList.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.DisplayItemList toBean()
/*     */     {
/* 337 */       return DisplayItemList.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DisplayItemList toDataIf()
/*     */     {
/* 343 */       return DisplayItemList.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.DisplayItemList toBeanIf()
/*     */     {
/* 348 */       return DisplayItemList.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFreshtime()
/*     */     {
/* 355 */       DisplayItemList.this._xdb_verify_unsafe_();
/* 356 */       return DisplayItemList.this.freshtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.DisplayItem> getDisplayitemlist()
/*     */     {
/* 363 */       DisplayItemList.this._xdb_verify_unsafe_();
/* 364 */       return xdb.Consts.constList(DisplayItemList.this.displayitemlist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.DisplayItem> getDisplayitemlistAsData()
/*     */     {
/* 370 */       DisplayItemList.this._xdb_verify_unsafe_();
/*     */       
/* 372 */       DisplayItemList _o_ = DisplayItemList.this;
/* 373 */       List<xbean.DisplayItem> displayitemlist = new ArrayList();
/* 374 */       for (xbean.DisplayItem _v_ : _o_.displayitemlist)
/* 375 */         displayitemlist.add(new DisplayItem.Data(_v_));
/* 376 */       return displayitemlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFreshtime(long _v_)
/*     */     {
/* 383 */       DisplayItemList.this._xdb_verify_unsafe_();
/* 384 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 390 */       DisplayItemList.this._xdb_verify_unsafe_();
/* 391 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 397 */       DisplayItemList.this._xdb_verify_unsafe_();
/* 398 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 404 */       return DisplayItemList.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 410 */       return DisplayItemList.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 416 */       DisplayItemList.this._xdb_verify_unsafe_();
/* 417 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 423 */       return DisplayItemList.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 429 */       return DisplayItemList.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 435 */       DisplayItemList.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 442 */       return DisplayItemList.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 448 */       return DisplayItemList.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 454 */       return DisplayItemList.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 460 */       return DisplayItemList.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 466 */       return DisplayItemList.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 472 */       return DisplayItemList.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 478 */       return DisplayItemList.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.DisplayItemList
/*     */   {
/*     */     private long freshtime;
/*     */     
/*     */     private ArrayList<xbean.DisplayItem> displayitemlist;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 497 */       this.displayitemlist = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.DisplayItemList _o1_)
/*     */     {
/* 502 */       if ((_o1_ instanceof DisplayItemList)) { assign((DisplayItemList)_o1_);
/* 503 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 504 */       } else if ((_o1_ instanceof DisplayItemList.Const)) assign(((DisplayItemList.Const)_o1_).nThis()); else {
/* 505 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(DisplayItemList _o_) {
/* 510 */       this.freshtime = _o_.freshtime;
/* 511 */       this.displayitemlist = new ArrayList();
/* 512 */       for (xbean.DisplayItem _v_ : _o_.displayitemlist) {
/* 513 */         this.displayitemlist.add(new DisplayItem.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 518 */       this.freshtime = _o_.freshtime;
/* 519 */       this.displayitemlist = new ArrayList();
/* 520 */       for (xbean.DisplayItem _v_ : _o_.displayitemlist) {
/* 521 */         this.displayitemlist.add(new DisplayItem.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 527 */       _os_.marshal(this.freshtime);
/* 528 */       _os_.compact_uint32(this.displayitemlist.size());
/* 529 */       for (xbean.DisplayItem _v_ : this.displayitemlist)
/*     */       {
/* 531 */         _v_.marshal(_os_);
/*     */       }
/* 533 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 539 */       this.freshtime = _os_.unmarshal_long();
/* 540 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 542 */         xbean.DisplayItem _v_ = xbean.Pod.newDisplayItemData();
/* 543 */         _v_.unmarshal(_os_);
/* 544 */         this.displayitemlist.add(_v_);
/*     */       }
/* 546 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 552 */       int _size_ = 0;
/* 553 */       _size_ += CodedOutputStream.computeInt64Size(1, this.freshtime);
/* 554 */       for (xbean.DisplayItem _v_ : this.displayitemlist)
/*     */       {
/* 556 */         _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*     */       }
/* 558 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 566 */         _output_.writeInt64(1, this.freshtime);
/* 567 */         for (xbean.DisplayItem _v_ : this.displayitemlist)
/*     */         {
/* 569 */           _output_.writeMessage(2, _v_);
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 574 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 576 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 584 */         boolean done = false;
/* 585 */         while (!done)
/*     */         {
/* 587 */           int tag = _input_.readTag();
/* 588 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 592 */             done = true;
/* 593 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 597 */             this.freshtime = _input_.readInt64();
/* 598 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 602 */             xbean.DisplayItem _v_ = xbean.Pod.newDisplayItemData();
/* 603 */             _input_.readMessage(_v_);
/* 604 */             this.displayitemlist.add(_v_);
/* 605 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 609 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 611 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 620 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 624 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 626 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DisplayItemList copy()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DisplayItemList toData()
/*     */     {
/* 638 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.DisplayItemList toBean()
/*     */     {
/* 643 */       return new DisplayItemList(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DisplayItemList toDataIf()
/*     */     {
/* 649 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.DisplayItemList toBeanIf()
/*     */     {
/* 654 */       return new DisplayItemList(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 660 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 664 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 668 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 672 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 676 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 680 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 684 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFreshtime()
/*     */     {
/* 691 */       return this.freshtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.DisplayItem> getDisplayitemlist()
/*     */     {
/* 698 */       return this.displayitemlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.DisplayItem> getDisplayitemlistAsData()
/*     */     {
/* 705 */       return this.displayitemlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFreshtime(long _v_)
/*     */     {
/* 712 */       this.freshtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 718 */       if (!(_o1_ instanceof Data)) return false;
/* 719 */       Data _o_ = (Data)_o1_;
/* 720 */       if (this.freshtime != _o_.freshtime) return false;
/* 721 */       if (!this.displayitemlist.equals(_o_.displayitemlist)) return false;
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 728 */       int _h_ = 0;
/* 729 */       _h_ = (int)(_h_ + this.freshtime);
/* 730 */       _h_ += this.displayitemlist.hashCode();
/* 731 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 737 */       StringBuilder _sb_ = new StringBuilder();
/* 738 */       _sb_.append("(");
/* 739 */       _sb_.append(this.freshtime);
/* 740 */       _sb_.append(",");
/* 741 */       _sb_.append(this.displayitemlist);
/* 742 */       _sb_.append(")");
/* 743 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DisplayItemList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */