/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ 
/*      */ public final class RoleAuctionInfo extends xdb.XBean implements xbean.RoleAuctionInfo
/*      */ {
/*      */   private LinkedList<Long> auction_item_ids;
/*      */   private LinkedList<Long> auction_pet_ids;
/*      */   private HashMap<Long, xbean.Item> marketid2auctionitem;
/*      */   private HashMap<Long, xbean.Pet> marketid2auctionpet;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.auction_item_ids.clear();
/*   25 */     this.auction_pet_ids.clear();
/*   26 */     this.marketid2auctionitem.clear();
/*   27 */     this.marketid2auctionpet.clear();
/*      */   }
/*      */   
/*      */   RoleAuctionInfo(int __, xdb.XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.auction_item_ids = new LinkedList();
/*   34 */     this.auction_pet_ids = new LinkedList();
/*   35 */     this.marketid2auctionitem = new HashMap();
/*   36 */     this.marketid2auctionpet = new HashMap();
/*      */   }
/*      */   
/*      */   public RoleAuctionInfo()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleAuctionInfo(RoleAuctionInfo _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleAuctionInfo(xbean.RoleAuctionInfo _o1_, xdb.XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof RoleAuctionInfo)) { assign((RoleAuctionInfo)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleAuctionInfo _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.auction_item_ids = new LinkedList();
/*   62 */     this.auction_item_ids.addAll(_o_.auction_item_ids);
/*   63 */     this.auction_pet_ids = new LinkedList();
/*   64 */     this.auction_pet_ids.addAll(_o_.auction_pet_ids);
/*   65 */     this.marketid2auctionitem = new HashMap();
/*   66 */     for (Map.Entry<Long, xbean.Item> _e_ : _o_.marketid2auctionitem.entrySet())
/*   67 */       this.marketid2auctionitem.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "marketid2auctionitem"));
/*   68 */     this.marketid2auctionpet = new HashMap();
/*   69 */     for (Map.Entry<Long, xbean.Pet> _e_ : _o_.marketid2auctionpet.entrySet()) {
/*   70 */       this.marketid2auctionpet.put(_e_.getKey(), new Pet((xbean.Pet)_e_.getValue(), this, "marketid2auctionpet"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   75 */     this.auction_item_ids = new LinkedList();
/*   76 */     this.auction_item_ids.addAll(_o_.auction_item_ids);
/*   77 */     this.auction_pet_ids = new LinkedList();
/*   78 */     this.auction_pet_ids.addAll(_o_.auction_pet_ids);
/*   79 */     this.marketid2auctionitem = new HashMap();
/*   80 */     for (Map.Entry<Long, xbean.Item> _e_ : _o_.marketid2auctionitem.entrySet())
/*   81 */       this.marketid2auctionitem.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "marketid2auctionitem"));
/*   82 */     this.marketid2auctionpet = new HashMap();
/*   83 */     for (Map.Entry<Long, xbean.Pet> _e_ : _o_.marketid2auctionpet.entrySet()) {
/*   84 */       this.marketid2auctionpet.put(_e_.getKey(), new Pet((xbean.Pet)_e_.getValue(), this, "marketid2auctionpet"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.compact_uint32(this.auction_item_ids.size());
/*   92 */     for (Long _v_ : this.auction_item_ids)
/*      */     {
/*   94 */       _os_.marshal(_v_.longValue());
/*      */     }
/*   96 */     _os_.compact_uint32(this.auction_pet_ids.size());
/*   97 */     for (Long _v_ : this.auction_pet_ids)
/*      */     {
/*   99 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  101 */     _os_.compact_uint32(this.marketid2auctionitem.size());
/*  102 */     for (Map.Entry<Long, xbean.Item> _e_ : this.marketid2auctionitem.entrySet())
/*      */     {
/*  104 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  105 */       ((xbean.Item)_e_.getValue()).marshal(_os_);
/*      */     }
/*  107 */     _os_.compact_uint32(this.marketid2auctionpet.size());
/*  108 */     for (Map.Entry<Long, xbean.Pet> _e_ : this.marketid2auctionpet.entrySet())
/*      */     {
/*  110 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  111 */       ((xbean.Pet)_e_.getValue()).marshal(_os_);
/*      */     }
/*  113 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  119 */     _xdb_verify_unsafe_();
/*  120 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  122 */       long _v_ = 0L;
/*  123 */       _v_ = _os_.unmarshal_long();
/*  124 */       this.auction_item_ids.add(Long.valueOf(_v_));
/*      */     }
/*  126 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  128 */       long _v_ = 0L;
/*  129 */       _v_ = _os_.unmarshal_long();
/*  130 */       this.auction_pet_ids.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  133 */     int size = _os_.uncompact_uint32();
/*  134 */     if (size >= 12)
/*      */     {
/*  136 */       this.marketid2auctionitem = new HashMap(size * 2);
/*      */     }
/*  138 */     for (; size > 0; size--)
/*      */     {
/*  140 */       long _k_ = 0L;
/*  141 */       _k_ = _os_.unmarshal_long();
/*  142 */       xbean.Item _v_ = new Item(0, this, "marketid2auctionitem");
/*  143 */       _v_.unmarshal(_os_);
/*  144 */       this.marketid2auctionitem.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  148 */     int size = _os_.uncompact_uint32();
/*  149 */     if (size >= 12)
/*      */     {
/*  151 */       this.marketid2auctionpet = new HashMap(size * 2);
/*      */     }
/*  153 */     for (; size > 0; size--)
/*      */     {
/*  155 */       long _k_ = 0L;
/*  156 */       _k_ = _os_.unmarshal_long();
/*  157 */       xbean.Pet _v_ = new Pet(0, this, "marketid2auctionpet");
/*  158 */       _v_.unmarshal(_os_);
/*  159 */       this.marketid2auctionpet.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  162 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  168 */     _xdb_verify_unsafe_();
/*  169 */     int _size_ = 0;
/*  170 */     for (Long _v_ : this.auction_item_ids)
/*      */     {
/*  172 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */     }
/*  174 */     for (Long _v_ : this.auction_pet_ids)
/*      */     {
/*  176 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */     }
/*  178 */     for (Map.Entry<Long, xbean.Item> _e_ : this.marketid2auctionitem.entrySet())
/*      */     {
/*  180 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  181 */       _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */     }
/*  183 */     for (Map.Entry<Long, xbean.Pet> _e_ : this.marketid2auctionpet.entrySet())
/*      */     {
/*  185 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  186 */       _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */     }
/*  188 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  194 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  197 */       for (Long _v_ : this.auction_item_ids)
/*      */       {
/*  199 */         _output_.writeInt64(1, _v_.longValue());
/*      */       }
/*  201 */       for (Long _v_ : this.auction_pet_ids)
/*      */       {
/*  203 */         _output_.writeInt64(2, _v_.longValue());
/*      */       }
/*  205 */       for (Map.Entry<Long, xbean.Item> _e_ : this.marketid2auctionitem.entrySet())
/*      */       {
/*  207 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  208 */         _output_.writeMessage(3, (Message)_e_.getValue());
/*      */       }
/*  210 */       for (Map.Entry<Long, xbean.Pet> _e_ : this.marketid2auctionpet.entrySet())
/*      */       {
/*  212 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  213 */         _output_.writeMessage(4, (Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  218 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  220 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  226 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  229 */       boolean done = false;
/*  230 */       while (!done)
/*      */       {
/*  232 */         int tag = _input_.readTag();
/*  233 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  237 */           done = true;
/*  238 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  242 */           long _v_ = 0L;
/*  243 */           _v_ = _input_.readInt64();
/*  244 */           this.auction_item_ids.add(Long.valueOf(_v_));
/*  245 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  249 */           long _v_ = 0L;
/*  250 */           _v_ = _input_.readInt64();
/*  251 */           this.auction_pet_ids.add(Long.valueOf(_v_));
/*  252 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  256 */           long _k_ = 0L;
/*  257 */           _k_ = _input_.readInt64();
/*  258 */           int readTag = _input_.readTag();
/*  259 */           if (26 != readTag)
/*      */           {
/*  261 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  263 */           xbean.Item _v_ = new Item(0, this, "marketid2auctionitem");
/*  264 */           _input_.readMessage(_v_);
/*  265 */           this.marketid2auctionitem.put(Long.valueOf(_k_), _v_);
/*  266 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  270 */           long _k_ = 0L;
/*  271 */           _k_ = _input_.readInt64();
/*  272 */           int readTag = _input_.readTag();
/*  273 */           if (34 != readTag)
/*      */           {
/*  275 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  277 */           xbean.Pet _v_ = new Pet(0, this, "marketid2auctionpet");
/*  278 */           _input_.readMessage(_v_);
/*  279 */           this.marketid2auctionpet.put(Long.valueOf(_k_), _v_);
/*  280 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  284 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  286 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  295 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  299 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  301 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleAuctionInfo copy()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return new RoleAuctionInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleAuctionInfo toData()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleAuctionInfo toBean()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return new RoleAuctionInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleAuctionInfo toDataIf()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleAuctionInfo toBeanIf()
/*      */   {
/*  333 */     _xdb_verify_unsafe_();
/*  334 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getAuction_item_ids()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return xdb.Logs.logList(new xdb.LogKey(this, "auction_item_ids"), this.auction_item_ids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getAuction_item_idsAsData()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*      */     
/*  357 */     RoleAuctionInfo _o_ = this;
/*  358 */     List<Long> auction_item_ids = new LinkedList();
/*  359 */     auction_item_ids.addAll(_o_.auction_item_ids);
/*  360 */     return auction_item_ids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getAuction_pet_ids()
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     return xdb.Logs.logList(new xdb.LogKey(this, "auction_pet_ids"), this.auction_pet_ids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getAuction_pet_idsAsData()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*      */     
/*  376 */     RoleAuctionInfo _o_ = this;
/*  377 */     List<Long> auction_pet_ids = new LinkedList();
/*  378 */     auction_pet_ids.addAll(_o_.auction_pet_ids);
/*  379 */     return auction_pet_ids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.Item> getMarketid2auctionitem()
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     return xdb.Logs.logMap(new xdb.LogKey(this, "marketid2auctionitem"), this.marketid2auctionitem);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.Item> getMarketid2auctionitemAsData()
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*      */     
/*  396 */     RoleAuctionInfo _o_ = this;
/*  397 */     Map<Long, xbean.Item> marketid2auctionitem = new HashMap();
/*  398 */     for (Map.Entry<Long, xbean.Item> _e_ : _o_.marketid2auctionitem.entrySet())
/*  399 */       marketid2auctionitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  400 */     return marketid2auctionitem;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.Pet> getMarketid2auctionpet()
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     return xdb.Logs.logMap(new xdb.LogKey(this, "marketid2auctionpet"), this.marketid2auctionpet);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.Pet> getMarketid2auctionpetAsData()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*      */     
/*  417 */     RoleAuctionInfo _o_ = this;
/*  418 */     Map<Long, xbean.Pet> marketid2auctionpet = new HashMap();
/*  419 */     for (Map.Entry<Long, xbean.Pet> _e_ : _o_.marketid2auctionpet.entrySet())
/*  420 */       marketid2auctionpet.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/*  421 */     return marketid2auctionpet;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     RoleAuctionInfo _o_ = null;
/*  429 */     if ((_o1_ instanceof RoleAuctionInfo)) { _o_ = (RoleAuctionInfo)_o1_;
/*  430 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  431 */       return false;
/*  432 */     if (!this.auction_item_ids.equals(_o_.auction_item_ids)) return false;
/*  433 */     if (!this.auction_pet_ids.equals(_o_.auction_pet_ids)) return false;
/*  434 */     if (!this.marketid2auctionitem.equals(_o_.marketid2auctionitem)) return false;
/*  435 */     if (!this.marketid2auctionpet.equals(_o_.marketid2auctionpet)) return false;
/*  436 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     int _h_ = 0;
/*  444 */     _h_ += this.auction_item_ids.hashCode();
/*  445 */     _h_ += this.auction_pet_ids.hashCode();
/*  446 */     _h_ += this.marketid2auctionitem.hashCode();
/*  447 */     _h_ += this.marketid2auctionpet.hashCode();
/*  448 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  454 */     _xdb_verify_unsafe_();
/*  455 */     StringBuilder _sb_ = new StringBuilder();
/*  456 */     _sb_.append("(");
/*  457 */     _sb_.append(this.auction_item_ids);
/*  458 */     _sb_.append(",");
/*  459 */     _sb_.append(this.auction_pet_ids);
/*  460 */     _sb_.append(",");
/*  461 */     _sb_.append(this.marketid2auctionitem);
/*  462 */     _sb_.append(",");
/*  463 */     _sb_.append(this.marketid2auctionpet);
/*  464 */     _sb_.append(")");
/*  465 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  471 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  472 */     lb.add(new xdb.logs.ListenableChanged().setVarName("auction_item_ids"));
/*  473 */     lb.add(new xdb.logs.ListenableChanged().setVarName("auction_pet_ids"));
/*  474 */     lb.add(new xdb.logs.ListenableMap().setVarName("marketid2auctionitem"));
/*  475 */     lb.add(new xdb.logs.ListenableMap().setVarName("marketid2auctionpet"));
/*  476 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleAuctionInfo {
/*      */     private Const() {}
/*      */     
/*      */     RoleAuctionInfo nThis() {
/*  483 */       return RoleAuctionInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  489 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleAuctionInfo copy()
/*      */     {
/*  495 */       return RoleAuctionInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleAuctionInfo toData()
/*      */     {
/*  501 */       return RoleAuctionInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleAuctionInfo toBean()
/*      */     {
/*  506 */       return RoleAuctionInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleAuctionInfo toDataIf()
/*      */     {
/*  512 */       return RoleAuctionInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleAuctionInfo toBeanIf()
/*      */     {
/*  517 */       return RoleAuctionInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAuction_item_ids()
/*      */     {
/*  524 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*  525 */       return xdb.Consts.constList(RoleAuctionInfo.this.auction_item_ids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getAuction_item_idsAsData()
/*      */     {
/*  531 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  533 */       RoleAuctionInfo _o_ = RoleAuctionInfo.this;
/*  534 */       List<Long> auction_item_ids = new LinkedList();
/*  535 */       auction_item_ids.addAll(_o_.auction_item_ids);
/*  536 */       return auction_item_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAuction_pet_ids()
/*      */     {
/*  543 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*  544 */       return xdb.Consts.constList(RoleAuctionInfo.this.auction_pet_ids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getAuction_pet_idsAsData()
/*      */     {
/*  550 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  552 */       RoleAuctionInfo _o_ = RoleAuctionInfo.this;
/*  553 */       List<Long> auction_pet_ids = new LinkedList();
/*  554 */       auction_pet_ids.addAll(_o_.auction_pet_ids);
/*  555 */       return auction_pet_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Item> getMarketid2auctionitem()
/*      */     {
/*  562 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*  563 */       return xdb.Consts.constMap(RoleAuctionInfo.this.marketid2auctionitem);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Item> getMarketid2auctionitemAsData()
/*      */     {
/*  570 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  572 */       RoleAuctionInfo _o_ = RoleAuctionInfo.this;
/*  573 */       Map<Long, xbean.Item> marketid2auctionitem = new HashMap();
/*  574 */       for (Map.Entry<Long, xbean.Item> _e_ : _o_.marketid2auctionitem.entrySet())
/*  575 */         marketid2auctionitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  576 */       return marketid2auctionitem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Pet> getMarketid2auctionpet()
/*      */     {
/*  583 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*  584 */       return xdb.Consts.constMap(RoleAuctionInfo.this.marketid2auctionpet);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Pet> getMarketid2auctionpetAsData()
/*      */     {
/*  591 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  593 */       RoleAuctionInfo _o_ = RoleAuctionInfo.this;
/*  594 */       Map<Long, xbean.Pet> marketid2auctionpet = new HashMap();
/*  595 */       for (Map.Entry<Long, xbean.Pet> _e_ : _o_.marketid2auctionpet.entrySet())
/*  596 */         marketid2auctionpet.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/*  597 */       return marketid2auctionpet;
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  603 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*  604 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  610 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*  611 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  617 */       return RoleAuctionInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  623 */       return RoleAuctionInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  629 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*  630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  636 */       return RoleAuctionInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  642 */       return RoleAuctionInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  648 */       RoleAuctionInfo.this._xdb_verify_unsafe_();
/*  649 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  655 */       return RoleAuctionInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  661 */       return RoleAuctionInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  667 */       return RoleAuctionInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  673 */       return RoleAuctionInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  679 */       return RoleAuctionInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  685 */       return RoleAuctionInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  691 */       return RoleAuctionInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleAuctionInfo
/*      */   {
/*      */     private LinkedList<Long> auction_item_ids;
/*      */     
/*      */     private LinkedList<Long> auction_pet_ids;
/*      */     
/*      */     private HashMap<Long, xbean.Item> marketid2auctionitem;
/*      */     
/*      */     private HashMap<Long, xbean.Pet> marketid2auctionpet;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  709 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  714 */       this.auction_item_ids = new LinkedList();
/*  715 */       this.auction_pet_ids = new LinkedList();
/*  716 */       this.marketid2auctionitem = new HashMap();
/*  717 */       this.marketid2auctionpet = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.RoleAuctionInfo _o1_)
/*      */     {
/*  722 */       if ((_o1_ instanceof RoleAuctionInfo)) { assign((RoleAuctionInfo)_o1_);
/*  723 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  724 */       } else if ((_o1_ instanceof RoleAuctionInfo.Const)) assign(((RoleAuctionInfo.Const)_o1_).nThis()); else {
/*  725 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleAuctionInfo _o_) {
/*  730 */       this.auction_item_ids = new LinkedList();
/*  731 */       this.auction_item_ids.addAll(_o_.auction_item_ids);
/*  732 */       this.auction_pet_ids = new LinkedList();
/*  733 */       this.auction_pet_ids.addAll(_o_.auction_pet_ids);
/*  734 */       this.marketid2auctionitem = new HashMap();
/*  735 */       for (Map.Entry<Long, xbean.Item> _e_ : _o_.marketid2auctionitem.entrySet())
/*  736 */         this.marketid2auctionitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  737 */       this.marketid2auctionpet = new HashMap();
/*  738 */       for (Map.Entry<Long, xbean.Pet> _e_ : _o_.marketid2auctionpet.entrySet()) {
/*  739 */         this.marketid2auctionpet.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  744 */       this.auction_item_ids = new LinkedList();
/*  745 */       this.auction_item_ids.addAll(_o_.auction_item_ids);
/*  746 */       this.auction_pet_ids = new LinkedList();
/*  747 */       this.auction_pet_ids.addAll(_o_.auction_pet_ids);
/*  748 */       this.marketid2auctionitem = new HashMap();
/*  749 */       for (Map.Entry<Long, xbean.Item> _e_ : _o_.marketid2auctionitem.entrySet())
/*  750 */         this.marketid2auctionitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  751 */       this.marketid2auctionpet = new HashMap();
/*  752 */       for (Map.Entry<Long, xbean.Pet> _e_ : _o_.marketid2auctionpet.entrySet()) {
/*  753 */         this.marketid2auctionpet.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  759 */       _os_.compact_uint32(this.auction_item_ids.size());
/*  760 */       for (Long _v_ : this.auction_item_ids)
/*      */       {
/*  762 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  764 */       _os_.compact_uint32(this.auction_pet_ids.size());
/*  765 */       for (Long _v_ : this.auction_pet_ids)
/*      */       {
/*  767 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  769 */       _os_.compact_uint32(this.marketid2auctionitem.size());
/*  770 */       for (Map.Entry<Long, xbean.Item> _e_ : this.marketid2auctionitem.entrySet())
/*      */       {
/*  772 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  773 */         ((xbean.Item)_e_.getValue()).marshal(_os_);
/*      */       }
/*  775 */       _os_.compact_uint32(this.marketid2auctionpet.size());
/*  776 */       for (Map.Entry<Long, xbean.Pet> _e_ : this.marketid2auctionpet.entrySet())
/*      */       {
/*  778 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  779 */         ((xbean.Pet)_e_.getValue()).marshal(_os_);
/*      */       }
/*  781 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  787 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  789 */         long _v_ = 0L;
/*  790 */         _v_ = _os_.unmarshal_long();
/*  791 */         this.auction_item_ids.add(Long.valueOf(_v_));
/*      */       }
/*  793 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  795 */         long _v_ = 0L;
/*  796 */         _v_ = _os_.unmarshal_long();
/*  797 */         this.auction_pet_ids.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/*  800 */       int size = _os_.uncompact_uint32();
/*  801 */       if (size >= 12)
/*      */       {
/*  803 */         this.marketid2auctionitem = new HashMap(size * 2);
/*      */       }
/*  805 */       for (; size > 0; size--)
/*      */       {
/*  807 */         long _k_ = 0L;
/*  808 */         _k_ = _os_.unmarshal_long();
/*  809 */         xbean.Item _v_ = xbean.Pod.newItemData();
/*  810 */         _v_.unmarshal(_os_);
/*  811 */         this.marketid2auctionitem.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  815 */       int size = _os_.uncompact_uint32();
/*  816 */       if (size >= 12)
/*      */       {
/*  818 */         this.marketid2auctionpet = new HashMap(size * 2);
/*      */       }
/*  820 */       for (; size > 0; size--)
/*      */       {
/*  822 */         long _k_ = 0L;
/*  823 */         _k_ = _os_.unmarshal_long();
/*  824 */         xbean.Pet _v_ = xbean.Pod.newPetData();
/*  825 */         _v_.unmarshal(_os_);
/*  826 */         this.marketid2auctionpet.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  829 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  835 */       int _size_ = 0;
/*  836 */       for (Long _v_ : this.auction_item_ids)
/*      */       {
/*  838 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */       }
/*  840 */       for (Long _v_ : this.auction_pet_ids)
/*      */       {
/*  842 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */       }
/*  844 */       for (Map.Entry<Long, xbean.Item> _e_ : this.marketid2auctionitem.entrySet())
/*      */       {
/*  846 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  847 */         _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */       }
/*  849 */       for (Map.Entry<Long, xbean.Pet> _e_ : this.marketid2auctionpet.entrySet())
/*      */       {
/*  851 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  852 */         _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */       }
/*  854 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  862 */         for (Long _v_ : this.auction_item_ids)
/*      */         {
/*  864 */           _output_.writeInt64(1, _v_.longValue());
/*      */         }
/*  866 */         for (Long _v_ : this.auction_pet_ids)
/*      */         {
/*  868 */           _output_.writeInt64(2, _v_.longValue());
/*      */         }
/*  870 */         for (Map.Entry<Long, xbean.Item> _e_ : this.marketid2auctionitem.entrySet())
/*      */         {
/*  872 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  873 */           _output_.writeMessage(3, (Message)_e_.getValue());
/*      */         }
/*  875 */         for (Map.Entry<Long, xbean.Pet> _e_ : this.marketid2auctionpet.entrySet())
/*      */         {
/*  877 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  878 */           _output_.writeMessage(4, (Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  883 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  885 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  893 */         boolean done = false;
/*  894 */         while (!done)
/*      */         {
/*  896 */           int tag = _input_.readTag();
/*  897 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  901 */             done = true;
/*  902 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  906 */             long _v_ = 0L;
/*  907 */             _v_ = _input_.readInt64();
/*  908 */             this.auction_item_ids.add(Long.valueOf(_v_));
/*  909 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  913 */             long _v_ = 0L;
/*  914 */             _v_ = _input_.readInt64();
/*  915 */             this.auction_pet_ids.add(Long.valueOf(_v_));
/*  916 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  920 */             long _k_ = 0L;
/*  921 */             _k_ = _input_.readInt64();
/*  922 */             int readTag = _input_.readTag();
/*  923 */             if (26 != readTag)
/*      */             {
/*  925 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  927 */             xbean.Item _v_ = xbean.Pod.newItemData();
/*  928 */             _input_.readMessage(_v_);
/*  929 */             this.marketid2auctionitem.put(Long.valueOf(_k_), _v_);
/*  930 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  934 */             long _k_ = 0L;
/*  935 */             _k_ = _input_.readInt64();
/*  936 */             int readTag = _input_.readTag();
/*  937 */             if (34 != readTag)
/*      */             {
/*  939 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  941 */             xbean.Pet _v_ = xbean.Pod.newPetData();
/*  942 */             _input_.readMessage(_v_);
/*  943 */             this.marketid2auctionpet.put(Long.valueOf(_k_), _v_);
/*  944 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  948 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  950 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  959 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  963 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  965 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleAuctionInfo copy()
/*      */     {
/*  971 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleAuctionInfo toData()
/*      */     {
/*  977 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleAuctionInfo toBean()
/*      */     {
/*  982 */       return new RoleAuctionInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleAuctionInfo toDataIf()
/*      */     {
/*  988 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleAuctionInfo toBeanIf()
/*      */     {
/*  993 */       return new RoleAuctionInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  999 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1003 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1007 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1011 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1015 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1019 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1023 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAuction_item_ids()
/*      */     {
/* 1030 */       return this.auction_item_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAuction_item_idsAsData()
/*      */     {
/* 1037 */       return this.auction_item_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAuction_pet_ids()
/*      */     {
/* 1044 */       return this.auction_pet_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAuction_pet_idsAsData()
/*      */     {
/* 1051 */       return this.auction_pet_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Item> getMarketid2auctionitem()
/*      */     {
/* 1058 */       return this.marketid2auctionitem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Item> getMarketid2auctionitemAsData()
/*      */     {
/* 1065 */       return this.marketid2auctionitem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Pet> getMarketid2auctionpet()
/*      */     {
/* 1072 */       return this.marketid2auctionpet;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Pet> getMarketid2auctionpetAsData()
/*      */     {
/* 1079 */       return this.marketid2auctionpet;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1085 */       if (!(_o1_ instanceof Data)) return false;
/* 1086 */       Data _o_ = (Data)_o1_;
/* 1087 */       if (!this.auction_item_ids.equals(_o_.auction_item_ids)) return false;
/* 1088 */       if (!this.auction_pet_ids.equals(_o_.auction_pet_ids)) return false;
/* 1089 */       if (!this.marketid2auctionitem.equals(_o_.marketid2auctionitem)) return false;
/* 1090 */       if (!this.marketid2auctionpet.equals(_o_.marketid2auctionpet)) return false;
/* 1091 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1097 */       int _h_ = 0;
/* 1098 */       _h_ += this.auction_item_ids.hashCode();
/* 1099 */       _h_ += this.auction_pet_ids.hashCode();
/* 1100 */       _h_ += this.marketid2auctionitem.hashCode();
/* 1101 */       _h_ += this.marketid2auctionpet.hashCode();
/* 1102 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1108 */       StringBuilder _sb_ = new StringBuilder();
/* 1109 */       _sb_.append("(");
/* 1110 */       _sb_.append(this.auction_item_ids);
/* 1111 */       _sb_.append(",");
/* 1112 */       _sb_.append(this.auction_pet_ids);
/* 1113 */       _sb_.append(",");
/* 1114 */       _sb_.append(this.marketid2auctionitem);
/* 1115 */       _sb_.append(",");
/* 1116 */       _sb_.append(this.marketid2auctionpet);
/* 1117 */       _sb_.append(")");
/* 1118 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleAuctionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */