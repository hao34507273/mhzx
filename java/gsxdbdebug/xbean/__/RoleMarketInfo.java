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
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class RoleMarketInfo extends XBean implements xbean.RoleMarketInfo
/*      */ {
/*      */   private LinkedList<Long> concern_item_ids;
/*      */   private LinkedList<Long> concern_pet_ids;
/*      */   private LinkedList<Long> onshelf_item_ids;
/*      */   private LinkedList<Long> onshelf_pet_ids;
/*      */   private long sale_gold_num;
/*      */   private HashMap<Long, xbean.MarketItem> marketid2timeoutorselleditem;
/*      */   private HashMap<Long, xbean.MarketPet> marketid2timeoutorselledpet;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.concern_item_ids.clear();
/*   31 */     this.concern_pet_ids.clear();
/*   32 */     this.onshelf_item_ids.clear();
/*   33 */     this.onshelf_pet_ids.clear();
/*   34 */     this.sale_gold_num = 0L;
/*   35 */     this.marketid2timeoutorselleditem.clear();
/*   36 */     this.marketid2timeoutorselledpet.clear();
/*      */   }
/*      */   
/*      */   RoleMarketInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.concern_item_ids = new LinkedList();
/*   43 */     this.concern_pet_ids = new LinkedList();
/*   44 */     this.onshelf_item_ids = new LinkedList();
/*   45 */     this.onshelf_pet_ids = new LinkedList();
/*   46 */     this.marketid2timeoutorselleditem = new HashMap();
/*   47 */     this.marketid2timeoutorselledpet = new HashMap();
/*      */   }
/*      */   
/*      */   public RoleMarketInfo()
/*      */   {
/*   52 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleMarketInfo(RoleMarketInfo _o_)
/*      */   {
/*   57 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleMarketInfo(xbean.RoleMarketInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   62 */     super(_xp_, _vn_);
/*   63 */     if ((_o1_ instanceof RoleMarketInfo)) { assign((RoleMarketInfo)_o1_);
/*   64 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   65 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   66 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleMarketInfo _o_) {
/*   71 */     _o_._xdb_verify_unsafe_();
/*   72 */     this.concern_item_ids = new LinkedList();
/*   73 */     this.concern_item_ids.addAll(_o_.concern_item_ids);
/*   74 */     this.concern_pet_ids = new LinkedList();
/*   75 */     this.concern_pet_ids.addAll(_o_.concern_pet_ids);
/*   76 */     this.onshelf_item_ids = new LinkedList();
/*   77 */     this.onshelf_item_ids.addAll(_o_.onshelf_item_ids);
/*   78 */     this.onshelf_pet_ids = new LinkedList();
/*   79 */     this.onshelf_pet_ids.addAll(_o_.onshelf_pet_ids);
/*   80 */     this.sale_gold_num = _o_.sale_gold_num;
/*   81 */     this.marketid2timeoutorselleditem = new HashMap();
/*   82 */     for (Map.Entry<Long, xbean.MarketItem> _e_ : _o_.marketid2timeoutorselleditem.entrySet())
/*   83 */       this.marketid2timeoutorselleditem.put(_e_.getKey(), new MarketItem((xbean.MarketItem)_e_.getValue(), this, "marketid2timeoutorselleditem"));
/*   84 */     this.marketid2timeoutorselledpet = new HashMap();
/*   85 */     for (Map.Entry<Long, xbean.MarketPet> _e_ : _o_.marketid2timeoutorselledpet.entrySet()) {
/*   86 */       this.marketid2timeoutorselledpet.put(_e_.getKey(), new MarketPet((xbean.MarketPet)_e_.getValue(), this, "marketid2timeoutorselledpet"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   91 */     this.concern_item_ids = new LinkedList();
/*   92 */     this.concern_item_ids.addAll(_o_.concern_item_ids);
/*   93 */     this.concern_pet_ids = new LinkedList();
/*   94 */     this.concern_pet_ids.addAll(_o_.concern_pet_ids);
/*   95 */     this.onshelf_item_ids = new LinkedList();
/*   96 */     this.onshelf_item_ids.addAll(_o_.onshelf_item_ids);
/*   97 */     this.onshelf_pet_ids = new LinkedList();
/*   98 */     this.onshelf_pet_ids.addAll(_o_.onshelf_pet_ids);
/*   99 */     this.sale_gold_num = _o_.sale_gold_num;
/*  100 */     this.marketid2timeoutorselleditem = new HashMap();
/*  101 */     for (Map.Entry<Long, xbean.MarketItem> _e_ : _o_.marketid2timeoutorselleditem.entrySet())
/*  102 */       this.marketid2timeoutorselleditem.put(_e_.getKey(), new MarketItem((xbean.MarketItem)_e_.getValue(), this, "marketid2timeoutorselleditem"));
/*  103 */     this.marketid2timeoutorselledpet = new HashMap();
/*  104 */     for (Map.Entry<Long, xbean.MarketPet> _e_ : _o_.marketid2timeoutorselledpet.entrySet()) {
/*  105 */       this.marketid2timeoutorselledpet.put(_e_.getKey(), new MarketPet((xbean.MarketPet)_e_.getValue(), this, "marketid2timeoutorselledpet"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  111 */     _xdb_verify_unsafe_();
/*  112 */     _os_.compact_uint32(this.concern_item_ids.size());
/*  113 */     for (Long _v_ : this.concern_item_ids)
/*      */     {
/*  115 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  117 */     _os_.compact_uint32(this.concern_pet_ids.size());
/*  118 */     for (Long _v_ : this.concern_pet_ids)
/*      */     {
/*  120 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  122 */     _os_.compact_uint32(this.onshelf_item_ids.size());
/*  123 */     for (Long _v_ : this.onshelf_item_ids)
/*      */     {
/*  125 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  127 */     _os_.compact_uint32(this.onshelf_pet_ids.size());
/*  128 */     for (Long _v_ : this.onshelf_pet_ids)
/*      */     {
/*  130 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  132 */     _os_.marshal(this.sale_gold_num);
/*  133 */     _os_.compact_uint32(this.marketid2timeoutorselleditem.size());
/*  134 */     for (Map.Entry<Long, xbean.MarketItem> _e_ : this.marketid2timeoutorselleditem.entrySet())
/*      */     {
/*  136 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  137 */       ((xbean.MarketItem)_e_.getValue()).marshal(_os_);
/*      */     }
/*  139 */     _os_.compact_uint32(this.marketid2timeoutorselledpet.size());
/*  140 */     for (Map.Entry<Long, xbean.MarketPet> _e_ : this.marketid2timeoutorselledpet.entrySet())
/*      */     {
/*  142 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  143 */       ((xbean.MarketPet)_e_.getValue()).marshal(_os_);
/*      */     }
/*  145 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  151 */     _xdb_verify_unsafe_();
/*  152 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  154 */       long _v_ = 0L;
/*  155 */       _v_ = _os_.unmarshal_long();
/*  156 */       this.concern_item_ids.add(Long.valueOf(_v_));
/*      */     }
/*  158 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  160 */       long _v_ = 0L;
/*  161 */       _v_ = _os_.unmarshal_long();
/*  162 */       this.concern_pet_ids.add(Long.valueOf(_v_));
/*      */     }
/*  164 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  166 */       long _v_ = 0L;
/*  167 */       _v_ = _os_.unmarshal_long();
/*  168 */       this.onshelf_item_ids.add(Long.valueOf(_v_));
/*      */     }
/*  170 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  172 */       long _v_ = 0L;
/*  173 */       _v_ = _os_.unmarshal_long();
/*  174 */       this.onshelf_pet_ids.add(Long.valueOf(_v_));
/*      */     }
/*  176 */     this.sale_gold_num = _os_.unmarshal_long();
/*      */     
/*  178 */     int size = _os_.uncompact_uint32();
/*  179 */     if (size >= 12)
/*      */     {
/*  181 */       this.marketid2timeoutorselleditem = new HashMap(size * 2);
/*      */     }
/*  183 */     for (; size > 0; size--)
/*      */     {
/*  185 */       long _k_ = 0L;
/*  186 */       _k_ = _os_.unmarshal_long();
/*  187 */       xbean.MarketItem _v_ = new MarketItem(0, this, "marketid2timeoutorselleditem");
/*  188 */       _v_.unmarshal(_os_);
/*  189 */       this.marketid2timeoutorselleditem.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  193 */     int size = _os_.uncompact_uint32();
/*  194 */     if (size >= 12)
/*      */     {
/*  196 */       this.marketid2timeoutorselledpet = new HashMap(size * 2);
/*      */     }
/*  198 */     for (; size > 0; size--)
/*      */     {
/*  200 */       long _k_ = 0L;
/*  201 */       _k_ = _os_.unmarshal_long();
/*  202 */       xbean.MarketPet _v_ = new MarketPet(0, this, "marketid2timeoutorselledpet");
/*  203 */       _v_.unmarshal(_os_);
/*  204 */       this.marketid2timeoutorselledpet.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  207 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  213 */     _xdb_verify_unsafe_();
/*  214 */     int _size_ = 0;
/*  215 */     for (Long _v_ : this.concern_item_ids)
/*      */     {
/*  217 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */     }
/*  219 */     for (Long _v_ : this.concern_pet_ids)
/*      */     {
/*  221 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */     }
/*  223 */     for (Long _v_ : this.onshelf_item_ids)
/*      */     {
/*  225 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */     }
/*  227 */     for (Long _v_ : this.onshelf_pet_ids)
/*      */     {
/*  229 */       _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */     }
/*  231 */     _size_ += CodedOutputStream.computeInt64Size(5, this.sale_gold_num);
/*  232 */     for (Map.Entry<Long, xbean.MarketItem> _e_ : this.marketid2timeoutorselleditem.entrySet())
/*      */     {
/*  234 */       _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getKey()).longValue());
/*  235 */       _size_ += CodedOutputStream.computeMessageSize(6, (ppbio.Message)_e_.getValue());
/*      */     }
/*  237 */     for (Map.Entry<Long, xbean.MarketPet> _e_ : this.marketid2timeoutorselledpet.entrySet())
/*      */     {
/*  239 */       _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/*  240 */       _size_ += CodedOutputStream.computeMessageSize(7, (ppbio.Message)_e_.getValue());
/*      */     }
/*  242 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  251 */       for (Long _v_ : this.concern_item_ids)
/*      */       {
/*  253 */         _output_.writeInt64(1, _v_.longValue());
/*      */       }
/*  255 */       for (Long _v_ : this.concern_pet_ids)
/*      */       {
/*  257 */         _output_.writeInt64(2, _v_.longValue());
/*      */       }
/*  259 */       for (Long _v_ : this.onshelf_item_ids)
/*      */       {
/*  261 */         _output_.writeInt64(3, _v_.longValue());
/*      */       }
/*  263 */       for (Long _v_ : this.onshelf_pet_ids)
/*      */       {
/*  265 */         _output_.writeInt64(4, _v_.longValue());
/*      */       }
/*  267 */       _output_.writeInt64(5, this.sale_gold_num);
/*  268 */       for (Map.Entry<Long, xbean.MarketItem> _e_ : this.marketid2timeoutorselleditem.entrySet())
/*      */       {
/*  270 */         _output_.writeInt64(6, ((Long)_e_.getKey()).longValue());
/*  271 */         _output_.writeMessage(6, (ppbio.Message)_e_.getValue());
/*      */       }
/*  273 */       for (Map.Entry<Long, xbean.MarketPet> _e_ : this.marketid2timeoutorselledpet.entrySet())
/*      */       {
/*  275 */         _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/*  276 */         _output_.writeMessage(7, (ppbio.Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  281 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  283 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  292 */       boolean done = false;
/*  293 */       while (!done)
/*      */       {
/*  295 */         int tag = _input_.readTag();
/*  296 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  300 */           done = true;
/*  301 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  305 */           long _v_ = 0L;
/*  306 */           _v_ = _input_.readInt64();
/*  307 */           this.concern_item_ids.add(Long.valueOf(_v_));
/*  308 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  312 */           long _v_ = 0L;
/*  313 */           _v_ = _input_.readInt64();
/*  314 */           this.concern_pet_ids.add(Long.valueOf(_v_));
/*  315 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  319 */           long _v_ = 0L;
/*  320 */           _v_ = _input_.readInt64();
/*  321 */           this.onshelf_item_ids.add(Long.valueOf(_v_));
/*  322 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  326 */           long _v_ = 0L;
/*  327 */           _v_ = _input_.readInt64();
/*  328 */           this.onshelf_pet_ids.add(Long.valueOf(_v_));
/*  329 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  333 */           this.sale_gold_num = _input_.readInt64();
/*  334 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  338 */           long _k_ = 0L;
/*  339 */           _k_ = _input_.readInt64();
/*  340 */           int readTag = _input_.readTag();
/*  341 */           if (50 != readTag)
/*      */           {
/*  343 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  345 */           xbean.MarketItem _v_ = new MarketItem(0, this, "marketid2timeoutorselleditem");
/*  346 */           _input_.readMessage(_v_);
/*  347 */           this.marketid2timeoutorselleditem.put(Long.valueOf(_k_), _v_);
/*  348 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  352 */           long _k_ = 0L;
/*  353 */           _k_ = _input_.readInt64();
/*  354 */           int readTag = _input_.readTag();
/*  355 */           if (58 != readTag)
/*      */           {
/*  357 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  359 */           xbean.MarketPet _v_ = new MarketPet(0, this, "marketid2timeoutorselledpet");
/*  360 */           _input_.readMessage(_v_);
/*  361 */           this.marketid2timeoutorselledpet.put(Long.valueOf(_k_), _v_);
/*  362 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  366 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  368 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  377 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  381 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  383 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleMarketInfo copy()
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     return new RoleMarketInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleMarketInfo toData()
/*      */   {
/*  396 */     _xdb_verify_unsafe_();
/*  397 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleMarketInfo toBean()
/*      */   {
/*  402 */     _xdb_verify_unsafe_();
/*  403 */     return new RoleMarketInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleMarketInfo toDataIf()
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleMarketInfo toBeanIf()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getConcern_item_ids()
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     return xdb.Logs.logList(new LogKey(this, "concern_item_ids"), this.concern_item_ids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getConcern_item_idsAsData()
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*      */     
/*  439 */     RoleMarketInfo _o_ = this;
/*  440 */     List<Long> concern_item_ids = new LinkedList();
/*  441 */     concern_item_ids.addAll(_o_.concern_item_ids);
/*  442 */     return concern_item_ids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getConcern_pet_ids()
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*  450 */     return xdb.Logs.logList(new LogKey(this, "concern_pet_ids"), this.concern_pet_ids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getConcern_pet_idsAsData()
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*      */     
/*  458 */     RoleMarketInfo _o_ = this;
/*  459 */     List<Long> concern_pet_ids = new LinkedList();
/*  460 */     concern_pet_ids.addAll(_o_.concern_pet_ids);
/*  461 */     return concern_pet_ids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getOnshelf_item_ids()
/*      */   {
/*  468 */     _xdb_verify_unsafe_();
/*  469 */     return xdb.Logs.logList(new LogKey(this, "onshelf_item_ids"), this.onshelf_item_ids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getOnshelf_item_idsAsData()
/*      */   {
/*  475 */     _xdb_verify_unsafe_();
/*      */     
/*  477 */     RoleMarketInfo _o_ = this;
/*  478 */     List<Long> onshelf_item_ids = new LinkedList();
/*  479 */     onshelf_item_ids.addAll(_o_.onshelf_item_ids);
/*  480 */     return onshelf_item_ids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getOnshelf_pet_ids()
/*      */   {
/*  487 */     _xdb_verify_unsafe_();
/*  488 */     return xdb.Logs.logList(new LogKey(this, "onshelf_pet_ids"), this.onshelf_pet_ids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getOnshelf_pet_idsAsData()
/*      */   {
/*  494 */     _xdb_verify_unsafe_();
/*      */     
/*  496 */     RoleMarketInfo _o_ = this;
/*  497 */     List<Long> onshelf_pet_ids = new LinkedList();
/*  498 */     onshelf_pet_ids.addAll(_o_.onshelf_pet_ids);
/*  499 */     return onshelf_pet_ids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSale_gold_num()
/*      */   {
/*  506 */     _xdb_verify_unsafe_();
/*  507 */     return this.sale_gold_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MarketItem> getMarketid2timeoutorselleditem()
/*      */   {
/*  514 */     _xdb_verify_unsafe_();
/*  515 */     return xdb.Logs.logMap(new LogKey(this, "marketid2timeoutorselleditem"), this.marketid2timeoutorselleditem);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MarketItem> getMarketid2timeoutorselleditemAsData()
/*      */   {
/*  522 */     _xdb_verify_unsafe_();
/*      */     
/*  524 */     RoleMarketInfo _o_ = this;
/*  525 */     Map<Long, xbean.MarketItem> marketid2timeoutorselleditem = new HashMap();
/*  526 */     for (Map.Entry<Long, xbean.MarketItem> _e_ : _o_.marketid2timeoutorselleditem.entrySet())
/*  527 */       marketid2timeoutorselleditem.put(_e_.getKey(), new MarketItem.Data((xbean.MarketItem)_e_.getValue()));
/*  528 */     return marketid2timeoutorselleditem;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MarketPet> getMarketid2timeoutorselledpet()
/*      */   {
/*  535 */     _xdb_verify_unsafe_();
/*  536 */     return xdb.Logs.logMap(new LogKey(this, "marketid2timeoutorselledpet"), this.marketid2timeoutorselledpet);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MarketPet> getMarketid2timeoutorselledpetAsData()
/*      */   {
/*  543 */     _xdb_verify_unsafe_();
/*      */     
/*  545 */     RoleMarketInfo _o_ = this;
/*  546 */     Map<Long, xbean.MarketPet> marketid2timeoutorselledpet = new HashMap();
/*  547 */     for (Map.Entry<Long, xbean.MarketPet> _e_ : _o_.marketid2timeoutorselledpet.entrySet())
/*  548 */       marketid2timeoutorselledpet.put(_e_.getKey(), new MarketPet.Data((xbean.MarketPet)_e_.getValue()));
/*  549 */     return marketid2timeoutorselledpet;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSale_gold_num(long _v_)
/*      */   {
/*  556 */     _xdb_verify_unsafe_();
/*  557 */     xdb.Logs.logIf(new LogKey(this, "sale_gold_num")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  561 */         new xdb.logs.LogLong(this, RoleMarketInfo.this.sale_gold_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  565 */             RoleMarketInfo.this.sale_gold_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  569 */     });
/*  570 */     this.sale_gold_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  576 */     _xdb_verify_unsafe_();
/*  577 */     RoleMarketInfo _o_ = null;
/*  578 */     if ((_o1_ instanceof RoleMarketInfo)) { _o_ = (RoleMarketInfo)_o1_;
/*  579 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  580 */       return false;
/*  581 */     if (!this.concern_item_ids.equals(_o_.concern_item_ids)) return false;
/*  582 */     if (!this.concern_pet_ids.equals(_o_.concern_pet_ids)) return false;
/*  583 */     if (!this.onshelf_item_ids.equals(_o_.onshelf_item_ids)) return false;
/*  584 */     if (!this.onshelf_pet_ids.equals(_o_.onshelf_pet_ids)) return false;
/*  585 */     if (this.sale_gold_num != _o_.sale_gold_num) return false;
/*  586 */     if (!this.marketid2timeoutorselleditem.equals(_o_.marketid2timeoutorselleditem)) return false;
/*  587 */     if (!this.marketid2timeoutorselledpet.equals(_o_.marketid2timeoutorselledpet)) return false;
/*  588 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  594 */     _xdb_verify_unsafe_();
/*  595 */     int _h_ = 0;
/*  596 */     _h_ += this.concern_item_ids.hashCode();
/*  597 */     _h_ += this.concern_pet_ids.hashCode();
/*  598 */     _h_ += this.onshelf_item_ids.hashCode();
/*  599 */     _h_ += this.onshelf_pet_ids.hashCode();
/*  600 */     _h_ = (int)(_h_ + this.sale_gold_num);
/*  601 */     _h_ += this.marketid2timeoutorselleditem.hashCode();
/*  602 */     _h_ += this.marketid2timeoutorselledpet.hashCode();
/*  603 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  609 */     _xdb_verify_unsafe_();
/*  610 */     StringBuilder _sb_ = new StringBuilder();
/*  611 */     _sb_.append("(");
/*  612 */     _sb_.append(this.concern_item_ids);
/*  613 */     _sb_.append(",");
/*  614 */     _sb_.append(this.concern_pet_ids);
/*  615 */     _sb_.append(",");
/*  616 */     _sb_.append(this.onshelf_item_ids);
/*  617 */     _sb_.append(",");
/*  618 */     _sb_.append(this.onshelf_pet_ids);
/*  619 */     _sb_.append(",");
/*  620 */     _sb_.append(this.sale_gold_num);
/*  621 */     _sb_.append(",");
/*  622 */     _sb_.append(this.marketid2timeoutorselleditem);
/*  623 */     _sb_.append(",");
/*  624 */     _sb_.append(this.marketid2timeoutorselledpet);
/*  625 */     _sb_.append(")");
/*  626 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  632 */     ListenableBean lb = new ListenableBean();
/*  633 */     lb.add(new ListenableChanged().setVarName("concern_item_ids"));
/*  634 */     lb.add(new ListenableChanged().setVarName("concern_pet_ids"));
/*  635 */     lb.add(new ListenableChanged().setVarName("onshelf_item_ids"));
/*  636 */     lb.add(new ListenableChanged().setVarName("onshelf_pet_ids"));
/*  637 */     lb.add(new ListenableChanged().setVarName("sale_gold_num"));
/*  638 */     lb.add(new xdb.logs.ListenableMap().setVarName("marketid2timeoutorselleditem"));
/*  639 */     lb.add(new xdb.logs.ListenableMap().setVarName("marketid2timeoutorselledpet"));
/*  640 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleMarketInfo {
/*      */     private Const() {}
/*      */     
/*      */     RoleMarketInfo nThis() {
/*  647 */       return RoleMarketInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleMarketInfo copy()
/*      */     {
/*  659 */       return RoleMarketInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleMarketInfo toData()
/*      */     {
/*  665 */       return RoleMarketInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleMarketInfo toBean()
/*      */     {
/*  670 */       return RoleMarketInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleMarketInfo toDataIf()
/*      */     {
/*  676 */       return RoleMarketInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleMarketInfo toBeanIf()
/*      */     {
/*  681 */       return RoleMarketInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getConcern_item_ids()
/*      */     {
/*  688 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  689 */       return xdb.Consts.constList(RoleMarketInfo.this.concern_item_ids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getConcern_item_idsAsData()
/*      */     {
/*  695 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*      */       
/*  697 */       RoleMarketInfo _o_ = RoleMarketInfo.this;
/*  698 */       List<Long> concern_item_ids = new LinkedList();
/*  699 */       concern_item_ids.addAll(_o_.concern_item_ids);
/*  700 */       return concern_item_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getConcern_pet_ids()
/*      */     {
/*  707 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  708 */       return xdb.Consts.constList(RoleMarketInfo.this.concern_pet_ids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getConcern_pet_idsAsData()
/*      */     {
/*  714 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*      */       
/*  716 */       RoleMarketInfo _o_ = RoleMarketInfo.this;
/*  717 */       List<Long> concern_pet_ids = new LinkedList();
/*  718 */       concern_pet_ids.addAll(_o_.concern_pet_ids);
/*  719 */       return concern_pet_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOnshelf_item_ids()
/*      */     {
/*  726 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  727 */       return xdb.Consts.constList(RoleMarketInfo.this.onshelf_item_ids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getOnshelf_item_idsAsData()
/*      */     {
/*  733 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*      */       
/*  735 */       RoleMarketInfo _o_ = RoleMarketInfo.this;
/*  736 */       List<Long> onshelf_item_ids = new LinkedList();
/*  737 */       onshelf_item_ids.addAll(_o_.onshelf_item_ids);
/*  738 */       return onshelf_item_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOnshelf_pet_ids()
/*      */     {
/*  745 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  746 */       return xdb.Consts.constList(RoleMarketInfo.this.onshelf_pet_ids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getOnshelf_pet_idsAsData()
/*      */     {
/*  752 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*      */       
/*  754 */       RoleMarketInfo _o_ = RoleMarketInfo.this;
/*  755 */       List<Long> onshelf_pet_ids = new LinkedList();
/*  756 */       onshelf_pet_ids.addAll(_o_.onshelf_pet_ids);
/*  757 */       return onshelf_pet_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSale_gold_num()
/*      */     {
/*  764 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  765 */       return RoleMarketInfo.this.sale_gold_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarketItem> getMarketid2timeoutorselleditem()
/*      */     {
/*  772 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  773 */       return xdb.Consts.constMap(RoleMarketInfo.this.marketid2timeoutorselleditem);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarketItem> getMarketid2timeoutorselleditemAsData()
/*      */     {
/*  780 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*      */       
/*  782 */       RoleMarketInfo _o_ = RoleMarketInfo.this;
/*  783 */       Map<Long, xbean.MarketItem> marketid2timeoutorselleditem = new HashMap();
/*  784 */       for (Map.Entry<Long, xbean.MarketItem> _e_ : _o_.marketid2timeoutorselleditem.entrySet())
/*  785 */         marketid2timeoutorselleditem.put(_e_.getKey(), new MarketItem.Data((xbean.MarketItem)_e_.getValue()));
/*  786 */       return marketid2timeoutorselleditem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarketPet> getMarketid2timeoutorselledpet()
/*      */     {
/*  793 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  794 */       return xdb.Consts.constMap(RoleMarketInfo.this.marketid2timeoutorselledpet);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarketPet> getMarketid2timeoutorselledpetAsData()
/*      */     {
/*  801 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*      */       
/*  803 */       RoleMarketInfo _o_ = RoleMarketInfo.this;
/*  804 */       Map<Long, xbean.MarketPet> marketid2timeoutorselledpet = new HashMap();
/*  805 */       for (Map.Entry<Long, xbean.MarketPet> _e_ : _o_.marketid2timeoutorselledpet.entrySet())
/*  806 */         marketid2timeoutorselledpet.put(_e_.getKey(), new MarketPet.Data((xbean.MarketPet)_e_.getValue()));
/*  807 */       return marketid2timeoutorselledpet;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSale_gold_num(long _v_)
/*      */     {
/*  814 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  815 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  821 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  822 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  828 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  829 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  835 */       return RoleMarketInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  841 */       return RoleMarketInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  847 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  848 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  854 */       return RoleMarketInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  860 */       return RoleMarketInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  866 */       RoleMarketInfo.this._xdb_verify_unsafe_();
/*  867 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  873 */       return RoleMarketInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  879 */       return RoleMarketInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  885 */       return RoleMarketInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  891 */       return RoleMarketInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  897 */       return RoleMarketInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  903 */       return RoleMarketInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  909 */       return RoleMarketInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleMarketInfo
/*      */   {
/*      */     private LinkedList<Long> concern_item_ids;
/*      */     
/*      */     private LinkedList<Long> concern_pet_ids;
/*      */     
/*      */     private LinkedList<Long> onshelf_item_ids;
/*      */     
/*      */     private LinkedList<Long> onshelf_pet_ids;
/*      */     
/*      */     private long sale_gold_num;
/*      */     
/*      */     private HashMap<Long, xbean.MarketItem> marketid2timeoutorselleditem;
/*      */     
/*      */     private HashMap<Long, xbean.MarketPet> marketid2timeoutorselledpet;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  938 */       this.concern_item_ids = new LinkedList();
/*  939 */       this.concern_pet_ids = new LinkedList();
/*  940 */       this.onshelf_item_ids = new LinkedList();
/*  941 */       this.onshelf_pet_ids = new LinkedList();
/*  942 */       this.marketid2timeoutorselleditem = new HashMap();
/*  943 */       this.marketid2timeoutorselledpet = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.RoleMarketInfo _o1_)
/*      */     {
/*  948 */       if ((_o1_ instanceof RoleMarketInfo)) { assign((RoleMarketInfo)_o1_);
/*  949 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  950 */       } else if ((_o1_ instanceof RoleMarketInfo.Const)) assign(((RoleMarketInfo.Const)_o1_).nThis()); else {
/*  951 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleMarketInfo _o_) {
/*  956 */       this.concern_item_ids = new LinkedList();
/*  957 */       this.concern_item_ids.addAll(_o_.concern_item_ids);
/*  958 */       this.concern_pet_ids = new LinkedList();
/*  959 */       this.concern_pet_ids.addAll(_o_.concern_pet_ids);
/*  960 */       this.onshelf_item_ids = new LinkedList();
/*  961 */       this.onshelf_item_ids.addAll(_o_.onshelf_item_ids);
/*  962 */       this.onshelf_pet_ids = new LinkedList();
/*  963 */       this.onshelf_pet_ids.addAll(_o_.onshelf_pet_ids);
/*  964 */       this.sale_gold_num = _o_.sale_gold_num;
/*  965 */       this.marketid2timeoutorselleditem = new HashMap();
/*  966 */       for (Map.Entry<Long, xbean.MarketItem> _e_ : _o_.marketid2timeoutorselleditem.entrySet())
/*  967 */         this.marketid2timeoutorselleditem.put(_e_.getKey(), new MarketItem.Data((xbean.MarketItem)_e_.getValue()));
/*  968 */       this.marketid2timeoutorselledpet = new HashMap();
/*  969 */       for (Map.Entry<Long, xbean.MarketPet> _e_ : _o_.marketid2timeoutorselledpet.entrySet()) {
/*  970 */         this.marketid2timeoutorselledpet.put(_e_.getKey(), new MarketPet.Data((xbean.MarketPet)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  975 */       this.concern_item_ids = new LinkedList();
/*  976 */       this.concern_item_ids.addAll(_o_.concern_item_ids);
/*  977 */       this.concern_pet_ids = new LinkedList();
/*  978 */       this.concern_pet_ids.addAll(_o_.concern_pet_ids);
/*  979 */       this.onshelf_item_ids = new LinkedList();
/*  980 */       this.onshelf_item_ids.addAll(_o_.onshelf_item_ids);
/*  981 */       this.onshelf_pet_ids = new LinkedList();
/*  982 */       this.onshelf_pet_ids.addAll(_o_.onshelf_pet_ids);
/*  983 */       this.sale_gold_num = _o_.sale_gold_num;
/*  984 */       this.marketid2timeoutorselleditem = new HashMap();
/*  985 */       for (Map.Entry<Long, xbean.MarketItem> _e_ : _o_.marketid2timeoutorselleditem.entrySet())
/*  986 */         this.marketid2timeoutorselleditem.put(_e_.getKey(), new MarketItem.Data((xbean.MarketItem)_e_.getValue()));
/*  987 */       this.marketid2timeoutorselledpet = new HashMap();
/*  988 */       for (Map.Entry<Long, xbean.MarketPet> _e_ : _o_.marketid2timeoutorselledpet.entrySet()) {
/*  989 */         this.marketid2timeoutorselledpet.put(_e_.getKey(), new MarketPet.Data((xbean.MarketPet)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  995 */       _os_.compact_uint32(this.concern_item_ids.size());
/*  996 */       for (Long _v_ : this.concern_item_ids)
/*      */       {
/*  998 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1000 */       _os_.compact_uint32(this.concern_pet_ids.size());
/* 1001 */       for (Long _v_ : this.concern_pet_ids)
/*      */       {
/* 1003 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1005 */       _os_.compact_uint32(this.onshelf_item_ids.size());
/* 1006 */       for (Long _v_ : this.onshelf_item_ids)
/*      */       {
/* 1008 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1010 */       _os_.compact_uint32(this.onshelf_pet_ids.size());
/* 1011 */       for (Long _v_ : this.onshelf_pet_ids)
/*      */       {
/* 1013 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1015 */       _os_.marshal(this.sale_gold_num);
/* 1016 */       _os_.compact_uint32(this.marketid2timeoutorselleditem.size());
/* 1017 */       for (Map.Entry<Long, xbean.MarketItem> _e_ : this.marketid2timeoutorselleditem.entrySet())
/*      */       {
/* 1019 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1020 */         ((xbean.MarketItem)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1022 */       _os_.compact_uint32(this.marketid2timeoutorselledpet.size());
/* 1023 */       for (Map.Entry<Long, xbean.MarketPet> _e_ : this.marketid2timeoutorselledpet.entrySet())
/*      */       {
/* 1025 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1026 */         ((xbean.MarketPet)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1028 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1034 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1036 */         long _v_ = 0L;
/* 1037 */         _v_ = _os_.unmarshal_long();
/* 1038 */         this.concern_item_ids.add(Long.valueOf(_v_));
/*      */       }
/* 1040 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1042 */         long _v_ = 0L;
/* 1043 */         _v_ = _os_.unmarshal_long();
/* 1044 */         this.concern_pet_ids.add(Long.valueOf(_v_));
/*      */       }
/* 1046 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1048 */         long _v_ = 0L;
/* 1049 */         _v_ = _os_.unmarshal_long();
/* 1050 */         this.onshelf_item_ids.add(Long.valueOf(_v_));
/*      */       }
/* 1052 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1054 */         long _v_ = 0L;
/* 1055 */         _v_ = _os_.unmarshal_long();
/* 1056 */         this.onshelf_pet_ids.add(Long.valueOf(_v_));
/*      */       }
/* 1058 */       this.sale_gold_num = _os_.unmarshal_long();
/*      */       
/* 1060 */       int size = _os_.uncompact_uint32();
/* 1061 */       if (size >= 12)
/*      */       {
/* 1063 */         this.marketid2timeoutorselleditem = new HashMap(size * 2);
/*      */       }
/* 1065 */       for (; size > 0; size--)
/*      */       {
/* 1067 */         long _k_ = 0L;
/* 1068 */         _k_ = _os_.unmarshal_long();
/* 1069 */         xbean.MarketItem _v_ = xbean.Pod.newMarketItemData();
/* 1070 */         _v_.unmarshal(_os_);
/* 1071 */         this.marketid2timeoutorselleditem.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1075 */       int size = _os_.uncompact_uint32();
/* 1076 */       if (size >= 12)
/*      */       {
/* 1078 */         this.marketid2timeoutorselledpet = new HashMap(size * 2);
/*      */       }
/* 1080 */       for (; size > 0; size--)
/*      */       {
/* 1082 */         long _k_ = 0L;
/* 1083 */         _k_ = _os_.unmarshal_long();
/* 1084 */         xbean.MarketPet _v_ = xbean.Pod.newMarketPetData();
/* 1085 */         _v_.unmarshal(_os_);
/* 1086 */         this.marketid2timeoutorselledpet.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1089 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1095 */       int _size_ = 0;
/* 1096 */       for (Long _v_ : this.concern_item_ids)
/*      */       {
/* 1098 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */       }
/* 1100 */       for (Long _v_ : this.concern_pet_ids)
/*      */       {
/* 1102 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */       }
/* 1104 */       for (Long _v_ : this.onshelf_item_ids)
/*      */       {
/* 1106 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */       }
/* 1108 */       for (Long _v_ : this.onshelf_pet_ids)
/*      */       {
/* 1110 */         _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */       }
/* 1112 */       _size_ += CodedOutputStream.computeInt64Size(5, this.sale_gold_num);
/* 1113 */       for (Map.Entry<Long, xbean.MarketItem> _e_ : this.marketid2timeoutorselleditem.entrySet())
/*      */       {
/* 1115 */         _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getKey()).longValue());
/* 1116 */         _size_ += CodedOutputStream.computeMessageSize(6, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1118 */       for (Map.Entry<Long, xbean.MarketPet> _e_ : this.marketid2timeoutorselledpet.entrySet())
/*      */       {
/* 1120 */         _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/* 1121 */         _size_ += CodedOutputStream.computeMessageSize(7, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1123 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1131 */         for (Long _v_ : this.concern_item_ids)
/*      */         {
/* 1133 */           _output_.writeInt64(1, _v_.longValue());
/*      */         }
/* 1135 */         for (Long _v_ : this.concern_pet_ids)
/*      */         {
/* 1137 */           _output_.writeInt64(2, _v_.longValue());
/*      */         }
/* 1139 */         for (Long _v_ : this.onshelf_item_ids)
/*      */         {
/* 1141 */           _output_.writeInt64(3, _v_.longValue());
/*      */         }
/* 1143 */         for (Long _v_ : this.onshelf_pet_ids)
/*      */         {
/* 1145 */           _output_.writeInt64(4, _v_.longValue());
/*      */         }
/* 1147 */         _output_.writeInt64(5, this.sale_gold_num);
/* 1148 */         for (Map.Entry<Long, xbean.MarketItem> _e_ : this.marketid2timeoutorselleditem.entrySet())
/*      */         {
/* 1150 */           _output_.writeInt64(6, ((Long)_e_.getKey()).longValue());
/* 1151 */           _output_.writeMessage(6, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1153 */         for (Map.Entry<Long, xbean.MarketPet> _e_ : this.marketid2timeoutorselledpet.entrySet())
/*      */         {
/* 1155 */           _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/* 1156 */           _output_.writeMessage(7, (ppbio.Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1161 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1163 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1171 */         boolean done = false;
/* 1172 */         while (!done)
/*      */         {
/* 1174 */           int tag = _input_.readTag();
/* 1175 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1179 */             done = true;
/* 1180 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1184 */             long _v_ = 0L;
/* 1185 */             _v_ = _input_.readInt64();
/* 1186 */             this.concern_item_ids.add(Long.valueOf(_v_));
/* 1187 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1191 */             long _v_ = 0L;
/* 1192 */             _v_ = _input_.readInt64();
/* 1193 */             this.concern_pet_ids.add(Long.valueOf(_v_));
/* 1194 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1198 */             long _v_ = 0L;
/* 1199 */             _v_ = _input_.readInt64();
/* 1200 */             this.onshelf_item_ids.add(Long.valueOf(_v_));
/* 1201 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1205 */             long _v_ = 0L;
/* 1206 */             _v_ = _input_.readInt64();
/* 1207 */             this.onshelf_pet_ids.add(Long.valueOf(_v_));
/* 1208 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1212 */             this.sale_gold_num = _input_.readInt64();
/* 1213 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1217 */             long _k_ = 0L;
/* 1218 */             _k_ = _input_.readInt64();
/* 1219 */             int readTag = _input_.readTag();
/* 1220 */             if (50 != readTag)
/*      */             {
/* 1222 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1224 */             xbean.MarketItem _v_ = xbean.Pod.newMarketItemData();
/* 1225 */             _input_.readMessage(_v_);
/* 1226 */             this.marketid2timeoutorselleditem.put(Long.valueOf(_k_), _v_);
/* 1227 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1231 */             long _k_ = 0L;
/* 1232 */             _k_ = _input_.readInt64();
/* 1233 */             int readTag = _input_.readTag();
/* 1234 */             if (58 != readTag)
/*      */             {
/* 1236 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1238 */             xbean.MarketPet _v_ = xbean.Pod.newMarketPetData();
/* 1239 */             _input_.readMessage(_v_);
/* 1240 */             this.marketid2timeoutorselledpet.put(Long.valueOf(_k_), _v_);
/* 1241 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1245 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1247 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1256 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1260 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1262 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleMarketInfo copy()
/*      */     {
/* 1268 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleMarketInfo toData()
/*      */     {
/* 1274 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleMarketInfo toBean()
/*      */     {
/* 1279 */       return new RoleMarketInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleMarketInfo toDataIf()
/*      */     {
/* 1285 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleMarketInfo toBeanIf()
/*      */     {
/* 1290 */       return new RoleMarketInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1296 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1300 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1304 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1308 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1312 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1316 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1320 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getConcern_item_ids()
/*      */     {
/* 1327 */       return this.concern_item_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getConcern_item_idsAsData()
/*      */     {
/* 1334 */       return this.concern_item_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getConcern_pet_ids()
/*      */     {
/* 1341 */       return this.concern_pet_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getConcern_pet_idsAsData()
/*      */     {
/* 1348 */       return this.concern_pet_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOnshelf_item_ids()
/*      */     {
/* 1355 */       return this.onshelf_item_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOnshelf_item_idsAsData()
/*      */     {
/* 1362 */       return this.onshelf_item_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOnshelf_pet_ids()
/*      */     {
/* 1369 */       return this.onshelf_pet_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOnshelf_pet_idsAsData()
/*      */     {
/* 1376 */       return this.onshelf_pet_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSale_gold_num()
/*      */     {
/* 1383 */       return this.sale_gold_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarketItem> getMarketid2timeoutorselleditem()
/*      */     {
/* 1390 */       return this.marketid2timeoutorselleditem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarketItem> getMarketid2timeoutorselleditemAsData()
/*      */     {
/* 1397 */       return this.marketid2timeoutorselleditem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarketPet> getMarketid2timeoutorselledpet()
/*      */     {
/* 1404 */       return this.marketid2timeoutorselledpet;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarketPet> getMarketid2timeoutorselledpetAsData()
/*      */     {
/* 1411 */       return this.marketid2timeoutorselledpet;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSale_gold_num(long _v_)
/*      */     {
/* 1418 */       this.sale_gold_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1424 */       if (!(_o1_ instanceof Data)) return false;
/* 1425 */       Data _o_ = (Data)_o1_;
/* 1426 */       if (!this.concern_item_ids.equals(_o_.concern_item_ids)) return false;
/* 1427 */       if (!this.concern_pet_ids.equals(_o_.concern_pet_ids)) return false;
/* 1428 */       if (!this.onshelf_item_ids.equals(_o_.onshelf_item_ids)) return false;
/* 1429 */       if (!this.onshelf_pet_ids.equals(_o_.onshelf_pet_ids)) return false;
/* 1430 */       if (this.sale_gold_num != _o_.sale_gold_num) return false;
/* 1431 */       if (!this.marketid2timeoutorselleditem.equals(_o_.marketid2timeoutorselleditem)) return false;
/* 1432 */       if (!this.marketid2timeoutorselledpet.equals(_o_.marketid2timeoutorselledpet)) return false;
/* 1433 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1439 */       int _h_ = 0;
/* 1440 */       _h_ += this.concern_item_ids.hashCode();
/* 1441 */       _h_ += this.concern_pet_ids.hashCode();
/* 1442 */       _h_ += this.onshelf_item_ids.hashCode();
/* 1443 */       _h_ += this.onshelf_pet_ids.hashCode();
/* 1444 */       _h_ = (int)(_h_ + this.sale_gold_num);
/* 1445 */       _h_ += this.marketid2timeoutorselleditem.hashCode();
/* 1446 */       _h_ += this.marketid2timeoutorselledpet.hashCode();
/* 1447 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1453 */       StringBuilder _sb_ = new StringBuilder();
/* 1454 */       _sb_.append("(");
/* 1455 */       _sb_.append(this.concern_item_ids);
/* 1456 */       _sb_.append(",");
/* 1457 */       _sb_.append(this.concern_pet_ids);
/* 1458 */       _sb_.append(",");
/* 1459 */       _sb_.append(this.onshelf_item_ids);
/* 1460 */       _sb_.append(",");
/* 1461 */       _sb_.append(this.onshelf_pet_ids);
/* 1462 */       _sb_.append(",");
/* 1463 */       _sb_.append(this.sale_gold_num);
/* 1464 */       _sb_.append(",");
/* 1465 */       _sb_.append(this.marketid2timeoutorselleditem);
/* 1466 */       _sb_.append(",");
/* 1467 */       _sb_.append(this.marketid2timeoutorselledpet);
/* 1468 */       _sb_.append(")");
/* 1469 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleMarketInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */