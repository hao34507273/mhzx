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
/*     */ public final class WingSkill extends XBean implements xbean.WingSkill
/*     */ {
/*     */   private int mainskillid;
/*     */   private ArrayList<Integer> subskillids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.mainskillid = 0;
/*  21 */     this.subskillids.clear();
/*     */   }
/*     */   
/*     */   WingSkill(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.mainskillid = 0;
/*  28 */     this.subskillids = new ArrayList();
/*     */   }
/*     */   
/*     */   public WingSkill()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public WingSkill(WingSkill _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   WingSkill(xbean.WingSkill _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof WingSkill)) { assign((WingSkill)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(WingSkill _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.mainskillid = _o_.mainskillid;
/*  54 */     this.subskillids = new ArrayList();
/*  55 */     this.subskillids.addAll(_o_.subskillids);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.mainskillid = _o_.mainskillid;
/*  61 */     this.subskillids = new ArrayList();
/*  62 */     this.subskillids.addAll(_o_.subskillids);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  68 */     _xdb_verify_unsafe_();
/*  69 */     _os_.marshal(this.mainskillid);
/*  70 */     _os_.compact_uint32(this.subskillids.size());
/*  71 */     for (Integer _v_ : this.subskillids)
/*     */     {
/*  73 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     _xdb_verify_unsafe_();
/*  82 */     this.mainskillid = _os_.unmarshal_int();
/*  83 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  85 */       int _v_ = 0;
/*  86 */       _v_ = _os_.unmarshal_int();
/*  87 */       this.subskillids.add(Integer.valueOf(_v_));
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     int _size_ = 0;
/*  97 */     _size_ += CodedOutputStream.computeInt32Size(1, this.mainskillid);
/*  98 */     for (Integer _v_ : this.subskillids)
/*     */     {
/* 100 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt32(1, this.mainskillid);
/* 112 */       for (Integer _v_ : this.subskillids)
/*     */       {
/* 114 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 119 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 121 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 127 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 130 */       boolean done = false;
/* 131 */       while (!done)
/*     */       {
/* 133 */         int tag = _input_.readTag();
/* 134 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 138 */           done = true;
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 143 */           this.mainskillid = _input_.readInt32();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 148 */           int _v_ = 0;
/* 149 */           _v_ = _input_.readInt32();
/* 150 */           this.subskillids.add(Integer.valueOf(_v_));
/* 151 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 155 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 157 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 166 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 170 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 172 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WingSkill copy()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new WingSkill(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WingSkill toData()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WingSkill toBean()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new WingSkill(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WingSkill toDataIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WingSkill toBeanIf()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMainskillid()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return this.mainskillid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getSubskillids()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return xdb.Logs.logList(new LogKey(this, "subskillids"), this.subskillids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getSubskillidsAsData()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/*     */     
/* 236 */     WingSkill _o_ = this;
/* 237 */     List<Integer> subskillids = new ArrayList();
/* 238 */     subskillids.addAll(_o_.subskillids);
/* 239 */     return subskillids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMainskillid(int _v_)
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     xdb.Logs.logIf(new LogKey(this, "mainskillid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 251 */         new xdb.logs.LogInt(this, WingSkill.this.mainskillid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 255 */             WingSkill.this.mainskillid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 259 */     });
/* 260 */     this.mainskillid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     WingSkill _o_ = null;
/* 268 */     if ((_o1_ instanceof WingSkill)) { _o_ = (WingSkill)_o1_;
/* 269 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 270 */       return false;
/* 271 */     if (this.mainskillid != _o_.mainskillid) return false;
/* 272 */     if (!this.subskillids.equals(_o_.subskillids)) return false;
/* 273 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     int _h_ = 0;
/* 281 */     _h_ += this.mainskillid;
/* 282 */     _h_ += this.subskillids.hashCode();
/* 283 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     StringBuilder _sb_ = new StringBuilder();
/* 291 */     _sb_.append("(");
/* 292 */     _sb_.append(this.mainskillid);
/* 293 */     _sb_.append(",");
/* 294 */     _sb_.append(this.subskillids);
/* 295 */     _sb_.append(")");
/* 296 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 302 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("mainskillid"));
/* 304 */     lb.add(new xdb.logs.ListenableChanged().setVarName("subskillids"));
/* 305 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.WingSkill {
/*     */     private Const() {}
/*     */     
/*     */     WingSkill nThis() {
/* 312 */       return WingSkill.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 318 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingSkill copy()
/*     */     {
/* 324 */       return WingSkill.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingSkill toData()
/*     */     {
/* 330 */       return WingSkill.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.WingSkill toBean()
/*     */     {
/* 335 */       return WingSkill.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingSkill toDataIf()
/*     */     {
/* 341 */       return WingSkill.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.WingSkill toBeanIf()
/*     */     {
/* 346 */       return WingSkill.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMainskillid()
/*     */     {
/* 353 */       WingSkill.this._xdb_verify_unsafe_();
/* 354 */       return WingSkill.this.mainskillid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getSubskillids()
/*     */     {
/* 361 */       WingSkill.this._xdb_verify_unsafe_();
/* 362 */       return xdb.Consts.constList(WingSkill.this.subskillids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getSubskillidsAsData()
/*     */     {
/* 368 */       WingSkill.this._xdb_verify_unsafe_();
/*     */       
/* 370 */       WingSkill _o_ = WingSkill.this;
/* 371 */       List<Integer> subskillids = new ArrayList();
/* 372 */       subskillids.addAll(_o_.subskillids);
/* 373 */       return subskillids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMainskillid(int _v_)
/*     */     {
/* 380 */       WingSkill.this._xdb_verify_unsafe_();
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 387 */       WingSkill.this._xdb_verify_unsafe_();
/* 388 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 394 */       WingSkill.this._xdb_verify_unsafe_();
/* 395 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 401 */       return WingSkill.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 407 */       return WingSkill.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 413 */       WingSkill.this._xdb_verify_unsafe_();
/* 414 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 420 */       return WingSkill.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 426 */       return WingSkill.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 432 */       WingSkill.this._xdb_verify_unsafe_();
/* 433 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 439 */       return WingSkill.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 445 */       return WingSkill.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 451 */       return WingSkill.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 457 */       return WingSkill.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 463 */       return WingSkill.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 469 */       return WingSkill.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 475 */       return WingSkill.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.WingSkill
/*     */   {
/*     */     private int mainskillid;
/*     */     
/*     */     private ArrayList<Integer> subskillids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 489 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 494 */       this.mainskillid = 0;
/* 495 */       this.subskillids = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.WingSkill _o1_)
/*     */     {
/* 500 */       if ((_o1_ instanceof WingSkill)) { assign((WingSkill)_o1_);
/* 501 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 502 */       } else if ((_o1_ instanceof WingSkill.Const)) assign(((WingSkill.Const)_o1_).nThis()); else {
/* 503 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(WingSkill _o_) {
/* 508 */       this.mainskillid = _o_.mainskillid;
/* 509 */       this.subskillids = new ArrayList();
/* 510 */       this.subskillids.addAll(_o_.subskillids);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 515 */       this.mainskillid = _o_.mainskillid;
/* 516 */       this.subskillids = new ArrayList();
/* 517 */       this.subskillids.addAll(_o_.subskillids);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 523 */       _os_.marshal(this.mainskillid);
/* 524 */       _os_.compact_uint32(this.subskillids.size());
/* 525 */       for (Integer _v_ : this.subskillids)
/*     */       {
/* 527 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 529 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 535 */       this.mainskillid = _os_.unmarshal_int();
/* 536 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 538 */         int _v_ = 0;
/* 539 */         _v_ = _os_.unmarshal_int();
/* 540 */         this.subskillids.add(Integer.valueOf(_v_));
/*     */       }
/* 542 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 548 */       int _size_ = 0;
/* 549 */       _size_ += CodedOutputStream.computeInt32Size(1, this.mainskillid);
/* 550 */       for (Integer _v_ : this.subskillids)
/*     */       {
/* 552 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 554 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 562 */         _output_.writeInt32(1, this.mainskillid);
/* 563 */         for (Integer _v_ : this.subskillids)
/*     */         {
/* 565 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 570 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 572 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 580 */         boolean done = false;
/* 581 */         while (!done)
/*     */         {
/* 583 */           int tag = _input_.readTag();
/* 584 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 588 */             done = true;
/* 589 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 593 */             this.mainskillid = _input_.readInt32();
/* 594 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 598 */             int _v_ = 0;
/* 599 */             _v_ = _input_.readInt32();
/* 600 */             this.subskillids.add(Integer.valueOf(_v_));
/* 601 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 605 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 607 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 616 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 620 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 622 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingSkill copy()
/*     */     {
/* 628 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingSkill toData()
/*     */     {
/* 634 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.WingSkill toBean()
/*     */     {
/* 639 */       return new WingSkill(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingSkill toDataIf()
/*     */     {
/* 645 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.WingSkill toBeanIf()
/*     */     {
/* 650 */       return new WingSkill(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 656 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 660 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 664 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 668 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 672 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 676 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 680 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMainskillid()
/*     */     {
/* 687 */       return this.mainskillid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getSubskillids()
/*     */     {
/* 694 */       return this.subskillids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getSubskillidsAsData()
/*     */     {
/* 701 */       return this.subskillids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMainskillid(int _v_)
/*     */     {
/* 708 */       this.mainskillid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 714 */       if (!(_o1_ instanceof Data)) return false;
/* 715 */       Data _o_ = (Data)_o1_;
/* 716 */       if (this.mainskillid != _o_.mainskillid) return false;
/* 717 */       if (!this.subskillids.equals(_o_.subskillids)) return false;
/* 718 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 724 */       int _h_ = 0;
/* 725 */       _h_ += this.mainskillid;
/* 726 */       _h_ += this.subskillids.hashCode();
/* 727 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 733 */       StringBuilder _sb_ = new StringBuilder();
/* 734 */       _sb_.append("(");
/* 735 */       _sb_.append(this.mainskillid);
/* 736 */       _sb_.append(",");
/* 737 */       _sb_.append(this.subskillids);
/* 738 */       _sb_.append(")");
/* 739 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WingSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */