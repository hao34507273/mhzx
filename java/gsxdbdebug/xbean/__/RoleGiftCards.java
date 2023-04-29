/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ 
/*     */ public final class RoleGiftCards extends xdb.XBean implements xbean.RoleGiftCards
/*     */ {
/*     */   private HashMap<String, xbean.RoleGiftCardInfo> cards;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.cards.clear();
/*     */   }
/*     */   
/*     */   RoleGiftCards(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.cards = new HashMap();
/*     */   }
/*     */   
/*     */   public RoleGiftCards()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleGiftCards(RoleGiftCards _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleGiftCards(xbean.RoleGiftCards _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof RoleGiftCards)) { assign((RoleGiftCards)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleGiftCards _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.cards = new HashMap();
/*  50 */     for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : _o_.cards.entrySet()) {
/*  51 */       this.cards.put(_e_.getKey(), new RoleGiftCardInfo((xbean.RoleGiftCardInfo)_e_.getValue(), this, "cards"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  56 */     this.cards = new HashMap();
/*  57 */     for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : _o_.cards.entrySet()) {
/*  58 */       this.cards.put(_e_.getKey(), new RoleGiftCardInfo((xbean.RoleGiftCardInfo)_e_.getValue(), this, "cards"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.compact_uint32(this.cards.size());
/*  66 */     for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : this.cards.entrySet())
/*     */     {
/*  68 */       _os_.marshal((String)_e_.getKey(), "UTF-16LE");
/*  69 */       ((xbean.RoleGiftCardInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*     */     
/*  79 */     int size = _os_.uncompact_uint32();
/*  80 */     if (size >= 12)
/*     */     {
/*  82 */       this.cards = new HashMap(size * 2);
/*     */     }
/*  84 */     for (; size > 0; size--)
/*     */     {
/*  86 */       String _k_ = "";
/*  87 */       _k_ = _os_.unmarshal_String("UTF-16LE");
/*  88 */       xbean.RoleGiftCardInfo _v_ = new RoleGiftCardInfo(0, this, "cards");
/*  89 */       _v_.unmarshal(_os_);
/*  90 */       this.cards.put(_k_, _v_);
/*     */     }
/*     */     
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     int _size_ = 0;
/* 101 */     for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : this.cards.entrySet())
/*     */     {
/*     */       try
/*     */       {
/* 105 */         _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 109 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 111 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 113 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 119 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 122 */       for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : this.cards.entrySet())
/*     */       {
/* 124 */         _output_.writeBytes(1, ppbio.ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/* 125 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 130 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 132 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 138 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 141 */       boolean done = false;
/* 142 */       while (!done)
/*     */       {
/* 144 */         int tag = _input_.readTag();
/* 145 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 149 */           done = true;
/* 150 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 154 */           String _k_ = "";
/* 155 */           _k_ = _input_.readBytes().toString("UTF-16LE");
/* 156 */           int readTag = _input_.readTag();
/* 157 */           if (10 != readTag)
/*     */           {
/* 159 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 161 */           xbean.RoleGiftCardInfo _v_ = new RoleGiftCardInfo(0, this, "cards");
/* 162 */           _input_.readMessage(_v_);
/* 163 */           this.cards.put(_k_, _v_);
/* 164 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 168 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 170 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 179 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 183 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 185 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGiftCards copy()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new RoleGiftCards(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGiftCards toData()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleGiftCards toBean()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new RoleGiftCards(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGiftCards toDataIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleGiftCards toBeanIf()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<String, xbean.RoleGiftCardInfo> getCards()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return xdb.Logs.logMap(new xdb.LogKey(this, "cards"), this.cards);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<String, xbean.RoleGiftCardInfo> getCardsAsData()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/*     */     
/* 242 */     RoleGiftCards _o_ = this;
/* 243 */     Map<String, xbean.RoleGiftCardInfo> cards = new HashMap();
/* 244 */     for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : _o_.cards.entrySet())
/* 245 */       cards.put(_e_.getKey(), new RoleGiftCardInfo.Data((xbean.RoleGiftCardInfo)_e_.getValue()));
/* 246 */     return cards;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     RoleGiftCards _o_ = null;
/* 254 */     if ((_o1_ instanceof RoleGiftCards)) { _o_ = (RoleGiftCards)_o1_;
/* 255 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 256 */       return false;
/* 257 */     if (!this.cards.equals(_o_.cards)) return false;
/* 258 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 264 */     _xdb_verify_unsafe_();
/* 265 */     int _h_ = 0;
/* 266 */     _h_ += this.cards.hashCode();
/* 267 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     StringBuilder _sb_ = new StringBuilder();
/* 275 */     _sb_.append("(");
/* 276 */     _sb_.append(this.cards);
/* 277 */     _sb_.append(")");
/* 278 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 284 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 285 */     lb.add(new xdb.logs.ListenableMap().setVarName("cards"));
/* 286 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleGiftCards {
/*     */     private Const() {}
/*     */     
/*     */     RoleGiftCards nThis() {
/* 293 */       return RoleGiftCards.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 299 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiftCards copy()
/*     */     {
/* 305 */       return RoleGiftCards.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiftCards toData()
/*     */     {
/* 311 */       return RoleGiftCards.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleGiftCards toBean()
/*     */     {
/* 316 */       return RoleGiftCards.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiftCards toDataIf()
/*     */     {
/* 322 */       return RoleGiftCards.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleGiftCards toBeanIf()
/*     */     {
/* 327 */       return RoleGiftCards.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<String, xbean.RoleGiftCardInfo> getCards()
/*     */     {
/* 334 */       RoleGiftCards.this._xdb_verify_unsafe_();
/* 335 */       return xdb.Consts.constMap(RoleGiftCards.this.cards);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<String, xbean.RoleGiftCardInfo> getCardsAsData()
/*     */     {
/* 342 */       RoleGiftCards.this._xdb_verify_unsafe_();
/*     */       
/* 344 */       RoleGiftCards _o_ = RoleGiftCards.this;
/* 345 */       Map<String, xbean.RoleGiftCardInfo> cards = new HashMap();
/* 346 */       for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : _o_.cards.entrySet())
/* 347 */         cards.put(_e_.getKey(), new RoleGiftCardInfo.Data((xbean.RoleGiftCardInfo)_e_.getValue()));
/* 348 */       return cards;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 354 */       RoleGiftCards.this._xdb_verify_unsafe_();
/* 355 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 361 */       RoleGiftCards.this._xdb_verify_unsafe_();
/* 362 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 368 */       return RoleGiftCards.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 374 */       return RoleGiftCards.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 380 */       RoleGiftCards.this._xdb_verify_unsafe_();
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 387 */       return RoleGiftCards.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 393 */       return RoleGiftCards.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 399 */       RoleGiftCards.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 406 */       return RoleGiftCards.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 412 */       return RoleGiftCards.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 418 */       return RoleGiftCards.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 424 */       return RoleGiftCards.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 430 */       return RoleGiftCards.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 436 */       return RoleGiftCards.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 442 */       return RoleGiftCards.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleGiftCards
/*     */   {
/*     */     private HashMap<String, xbean.RoleGiftCardInfo> cards;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 454 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 459 */       this.cards = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleGiftCards _o1_)
/*     */     {
/* 464 */       if ((_o1_ instanceof RoleGiftCards)) { assign((RoleGiftCards)_o1_);
/* 465 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 466 */       } else if ((_o1_ instanceof RoleGiftCards.Const)) assign(((RoleGiftCards.Const)_o1_).nThis()); else {
/* 467 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleGiftCards _o_) {
/* 472 */       this.cards = new HashMap();
/* 473 */       for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : _o_.cards.entrySet()) {
/* 474 */         this.cards.put(_e_.getKey(), new RoleGiftCardInfo.Data((xbean.RoleGiftCardInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 479 */       this.cards = new HashMap();
/* 480 */       for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : _o_.cards.entrySet()) {
/* 481 */         this.cards.put(_e_.getKey(), new RoleGiftCardInfo.Data((xbean.RoleGiftCardInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 487 */       _os_.compact_uint32(this.cards.size());
/* 488 */       for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : this.cards.entrySet())
/*     */       {
/* 490 */         _os_.marshal((String)_e_.getKey(), "UTF-16LE");
/* 491 */         ((xbean.RoleGiftCardInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 493 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 500 */       int size = _os_.uncompact_uint32();
/* 501 */       if (size >= 12)
/*     */       {
/* 503 */         this.cards = new HashMap(size * 2);
/*     */       }
/* 505 */       for (; size > 0; size--)
/*     */       {
/* 507 */         String _k_ = "";
/* 508 */         _k_ = _os_.unmarshal_String("UTF-16LE");
/* 509 */         xbean.RoleGiftCardInfo _v_ = xbean.Pod.newRoleGiftCardInfoData();
/* 510 */         _v_.unmarshal(_os_);
/* 511 */         this.cards.put(_k_, _v_);
/*     */       }
/*     */       
/* 514 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 520 */       int _size_ = 0;
/* 521 */       for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : this.cards.entrySet())
/*     */       {
/*     */         try
/*     */         {
/* 525 */           _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/*     */         }
/*     */         catch (java.io.UnsupportedEncodingException e)
/*     */         {
/* 529 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*     */         }
/* 531 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 533 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 541 */         for (Map.Entry<String, xbean.RoleGiftCardInfo> _e_ : this.cards.entrySet())
/*     */         {
/* 543 */           _output_.writeBytes(1, ppbio.ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/* 544 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 549 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 551 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 559 */         boolean done = false;
/* 560 */         while (!done)
/*     */         {
/* 562 */           int tag = _input_.readTag();
/* 563 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 567 */             done = true;
/* 568 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 572 */             String _k_ = "";
/* 573 */             _k_ = _input_.readBytes().toString("UTF-16LE");
/* 574 */             int readTag = _input_.readTag();
/* 575 */             if (10 != readTag)
/*     */             {
/* 577 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 579 */             xbean.RoleGiftCardInfo _v_ = xbean.Pod.newRoleGiftCardInfoData();
/* 580 */             _input_.readMessage(_v_);
/* 581 */             this.cards.put(_k_, _v_);
/* 582 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 586 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 588 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 597 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 601 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 603 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiftCards copy()
/*     */     {
/* 609 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiftCards toData()
/*     */     {
/* 615 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleGiftCards toBean()
/*     */     {
/* 620 */       return new RoleGiftCards(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiftCards toDataIf()
/*     */     {
/* 626 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleGiftCards toBeanIf()
/*     */     {
/* 631 */       return new RoleGiftCards(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 641 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 645 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 649 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 653 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 657 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 661 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<String, xbean.RoleGiftCardInfo> getCards()
/*     */     {
/* 668 */       return this.cards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<String, xbean.RoleGiftCardInfo> getCardsAsData()
/*     */     {
/* 675 */       return this.cards;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 681 */       if (!(_o1_ instanceof Data)) return false;
/* 682 */       Data _o_ = (Data)_o1_;
/* 683 */       if (!this.cards.equals(_o_.cards)) return false;
/* 684 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 690 */       int _h_ = 0;
/* 691 */       _h_ += this.cards.hashCode();
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.cards);
/* 701 */       _sb_.append(")");
/* 702 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleGiftCards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */