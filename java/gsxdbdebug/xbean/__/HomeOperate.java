/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class HomeOperate extends XBean implements xbean.HomeOperate
/*      */ {
/*      */   private HashMap<Integer, xbean.FurnitureUuIds> ownfurnitures;
/*      */   private SetX<Integer> canbuyitems;
/*      */   private HashMap<Integer, Integer> item2buynum;
/*      */   private int dayrefreshcount;
/*      */   private int dayrestorevigorcount;
/*      */   private int dayrestoresatiationcount;
/*      */   private int dayttrainpetcount;
/*      */   private long updatetime;
/*      */   private int homestate;
/*      */   private HashMap<Integer, Integer> canbuyitem2num;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   36 */     this.ownfurnitures.clear();
/*   37 */     this.canbuyitems.clear();
/*   38 */     this.item2buynum.clear();
/*   39 */     this.dayrefreshcount = 0;
/*   40 */     this.dayrestorevigorcount = 0;
/*   41 */     this.dayrestoresatiationcount = 0;
/*   42 */     this.dayttrainpetcount = 0;
/*   43 */     this.updatetime = 0L;
/*   44 */     this.homestate = 2;
/*   45 */     this.canbuyitem2num.clear();
/*      */   }
/*      */   
/*      */   HomeOperate(int __, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     this.ownfurnitures = new HashMap();
/*   52 */     this.canbuyitems = new SetX();
/*   53 */     this.item2buynum = new HashMap();
/*   54 */     this.dayrefreshcount = 0;
/*   55 */     this.dayrestorevigorcount = 0;
/*   56 */     this.dayrestoresatiationcount = 0;
/*   57 */     this.dayttrainpetcount = 0;
/*   58 */     this.updatetime = 0L;
/*   59 */     this.homestate = 2;
/*   60 */     this.canbuyitem2num = new HashMap();
/*      */   }
/*      */   
/*      */   public HomeOperate()
/*      */   {
/*   65 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public HomeOperate(HomeOperate _o_)
/*      */   {
/*   70 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   HomeOperate(xbean.HomeOperate _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   75 */     super(_xp_, _vn_);
/*   76 */     if ((_o1_ instanceof HomeOperate)) { assign((HomeOperate)_o1_);
/*   77 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   78 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   79 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(HomeOperate _o_) {
/*   84 */     _o_._xdb_verify_unsafe_();
/*   85 */     this.ownfurnitures = new HashMap();
/*   86 */     for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : _o_.ownfurnitures.entrySet())
/*   87 */       this.ownfurnitures.put(_e_.getKey(), new FurnitureUuIds((xbean.FurnitureUuIds)_e_.getValue(), this, "ownfurnitures"));
/*   88 */     this.canbuyitems = new SetX();
/*   89 */     this.canbuyitems.addAll(_o_.canbuyitems);
/*   90 */     this.item2buynum = new HashMap();
/*   91 */     for (Map.Entry<Integer, Integer> _e_ : _o_.item2buynum.entrySet())
/*   92 */       this.item2buynum.put(_e_.getKey(), _e_.getValue());
/*   93 */     this.dayrefreshcount = _o_.dayrefreshcount;
/*   94 */     this.dayrestorevigorcount = _o_.dayrestorevigorcount;
/*   95 */     this.dayrestoresatiationcount = _o_.dayrestoresatiationcount;
/*   96 */     this.dayttrainpetcount = _o_.dayttrainpetcount;
/*   97 */     this.updatetime = _o_.updatetime;
/*   98 */     this.homestate = _o_.homestate;
/*   99 */     this.canbuyitem2num = new HashMap();
/*  100 */     for (Map.Entry<Integer, Integer> _e_ : _o_.canbuyitem2num.entrySet()) {
/*  101 */       this.canbuyitem2num.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  106 */     this.ownfurnitures = new HashMap();
/*  107 */     for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : _o_.ownfurnitures.entrySet())
/*  108 */       this.ownfurnitures.put(_e_.getKey(), new FurnitureUuIds((xbean.FurnitureUuIds)_e_.getValue(), this, "ownfurnitures"));
/*  109 */     this.canbuyitems = new SetX();
/*  110 */     this.canbuyitems.addAll(_o_.canbuyitems);
/*  111 */     this.item2buynum = new HashMap();
/*  112 */     for (Map.Entry<Integer, Integer> _e_ : _o_.item2buynum.entrySet())
/*  113 */       this.item2buynum.put(_e_.getKey(), _e_.getValue());
/*  114 */     this.dayrefreshcount = _o_.dayrefreshcount;
/*  115 */     this.dayrestorevigorcount = _o_.dayrestorevigorcount;
/*  116 */     this.dayrestoresatiationcount = _o_.dayrestoresatiationcount;
/*  117 */     this.dayttrainpetcount = _o_.dayttrainpetcount;
/*  118 */     this.updatetime = _o_.updatetime;
/*  119 */     this.homestate = _o_.homestate;
/*  120 */     this.canbuyitem2num = new HashMap();
/*  121 */     for (Map.Entry<Integer, Integer> _e_ : _o_.canbuyitem2num.entrySet()) {
/*  122 */       this.canbuyitem2num.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  128 */     _xdb_verify_unsafe_();
/*  129 */     _os_.compact_uint32(this.ownfurnitures.size());
/*  130 */     for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : this.ownfurnitures.entrySet())
/*      */     {
/*  132 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  133 */       ((xbean.FurnitureUuIds)_e_.getValue()).marshal(_os_);
/*      */     }
/*  135 */     _os_.compact_uint32(this.canbuyitems.size());
/*  136 */     for (Integer _v_ : this.canbuyitems)
/*      */     {
/*  138 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  140 */     _os_.compact_uint32(this.item2buynum.size());
/*  141 */     for (Map.Entry<Integer, Integer> _e_ : this.item2buynum.entrySet())
/*      */     {
/*  143 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  144 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  146 */     _os_.marshal(this.dayrefreshcount);
/*  147 */     _os_.marshal(this.dayrestorevigorcount);
/*  148 */     _os_.marshal(this.dayrestoresatiationcount);
/*  149 */     _os_.marshal(this.dayttrainpetcount);
/*  150 */     _os_.marshal(this.updatetime);
/*  151 */     _os_.marshal(this.homestate);
/*  152 */     _os_.compact_uint32(this.canbuyitem2num.size());
/*  153 */     for (Map.Entry<Integer, Integer> _e_ : this.canbuyitem2num.entrySet())
/*      */     {
/*  155 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  156 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  158 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*      */     
/*  166 */     int size = _os_.uncompact_uint32();
/*  167 */     if (size >= 12)
/*      */     {
/*  169 */       this.ownfurnitures = new HashMap(size * 2);
/*      */     }
/*  171 */     for (; size > 0; size--)
/*      */     {
/*  173 */       int _k_ = 0;
/*  174 */       _k_ = _os_.unmarshal_int();
/*  175 */       xbean.FurnitureUuIds _v_ = new FurnitureUuIds(0, this, "ownfurnitures");
/*  176 */       _v_.unmarshal(_os_);
/*  177 */       this.ownfurnitures.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  180 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  182 */       int _v_ = 0;
/*  183 */       _v_ = _os_.unmarshal_int();
/*  184 */       this.canbuyitems.add(Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  187 */     int size = _os_.uncompact_uint32();
/*  188 */     if (size >= 12)
/*      */     {
/*  190 */       this.item2buynum = new HashMap(size * 2);
/*      */     }
/*  192 */     for (; size > 0; size--)
/*      */     {
/*  194 */       int _k_ = 0;
/*  195 */       _k_ = _os_.unmarshal_int();
/*  196 */       int _v_ = 0;
/*  197 */       _v_ = _os_.unmarshal_int();
/*  198 */       this.item2buynum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  201 */     this.dayrefreshcount = _os_.unmarshal_int();
/*  202 */     this.dayrestorevigorcount = _os_.unmarshal_int();
/*  203 */     this.dayrestoresatiationcount = _os_.unmarshal_int();
/*  204 */     this.dayttrainpetcount = _os_.unmarshal_int();
/*  205 */     this.updatetime = _os_.unmarshal_long();
/*  206 */     this.homestate = _os_.unmarshal_int();
/*      */     
/*  208 */     int size = _os_.uncompact_uint32();
/*  209 */     if (size >= 12)
/*      */     {
/*  211 */       this.canbuyitem2num = new HashMap(size * 2);
/*      */     }
/*  213 */     for (; size > 0; size--)
/*      */     {
/*  215 */       int _k_ = 0;
/*  216 */       _k_ = _os_.unmarshal_int();
/*  217 */       int _v_ = 0;
/*  218 */       _v_ = _os_.unmarshal_int();
/*  219 */       this.canbuyitem2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  222 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  228 */     _xdb_verify_unsafe_();
/*  229 */     int _size_ = 0;
/*  230 */     for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : this.ownfurnitures.entrySet())
/*      */     {
/*  232 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  233 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */     }
/*  235 */     for (Integer _v_ : this.canbuyitems)
/*      */     {
/*  237 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */     }
/*  239 */     for (Map.Entry<Integer, Integer> _e_ : this.item2buynum.entrySet())
/*      */     {
/*  241 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  242 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  244 */     _size_ += CodedOutputStream.computeInt32Size(4, this.dayrefreshcount);
/*  245 */     _size_ += CodedOutputStream.computeInt32Size(5, this.dayrestorevigorcount);
/*  246 */     _size_ += CodedOutputStream.computeInt32Size(6, this.dayrestoresatiationcount);
/*  247 */     _size_ += CodedOutputStream.computeInt32Size(7, this.dayttrainpetcount);
/*  248 */     _size_ += CodedOutputStream.computeInt64Size(8, this.updatetime);
/*  249 */     _size_ += CodedOutputStream.computeInt32Size(9, this.homestate);
/*  250 */     for (Map.Entry<Integer, Integer> _e_ : this.canbuyitem2num.entrySet())
/*      */     {
/*  252 */       _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getKey()).intValue());
/*  253 */       _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  255 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  264 */       for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : this.ownfurnitures.entrySet())
/*      */       {
/*  266 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  267 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  269 */       for (Integer _v_ : this.canbuyitems)
/*      */       {
/*  271 */         _output_.writeInt32(2, _v_.intValue());
/*      */       }
/*  273 */       for (Map.Entry<Integer, Integer> _e_ : this.item2buynum.entrySet())
/*      */       {
/*  275 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  276 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  278 */       _output_.writeInt32(4, this.dayrefreshcount);
/*  279 */       _output_.writeInt32(5, this.dayrestorevigorcount);
/*  280 */       _output_.writeInt32(6, this.dayrestoresatiationcount);
/*  281 */       _output_.writeInt32(7, this.dayttrainpetcount);
/*  282 */       _output_.writeInt64(8, this.updatetime);
/*  283 */       _output_.writeInt32(9, this.homestate);
/*  284 */       for (Map.Entry<Integer, Integer> _e_ : this.canbuyitem2num.entrySet())
/*      */       {
/*  286 */         _output_.writeInt32(10, ((Integer)_e_.getKey()).intValue());
/*  287 */         _output_.writeInt32(10, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  292 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  294 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  303 */       boolean done = false;
/*  304 */       while (!done)
/*      */       {
/*  306 */         int tag = _input_.readTag();
/*  307 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  311 */           done = true;
/*  312 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  316 */           int _k_ = 0;
/*  317 */           _k_ = _input_.readInt32();
/*  318 */           int readTag = _input_.readTag();
/*  319 */           if (10 != readTag)
/*      */           {
/*  321 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  323 */           xbean.FurnitureUuIds _v_ = new FurnitureUuIds(0, this, "ownfurnitures");
/*  324 */           _input_.readMessage(_v_);
/*  325 */           this.ownfurnitures.put(Integer.valueOf(_k_), _v_);
/*  326 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  330 */           int _v_ = 0;
/*  331 */           _v_ = _input_.readInt32();
/*  332 */           this.canbuyitems.add(Integer.valueOf(_v_));
/*  333 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  337 */           int _k_ = 0;
/*  338 */           _k_ = _input_.readInt32();
/*  339 */           int readTag = _input_.readTag();
/*  340 */           if (24 != readTag)
/*      */           {
/*  342 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  344 */           int _v_ = 0;
/*  345 */           _v_ = _input_.readInt32();
/*  346 */           this.item2buynum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  347 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  351 */           this.dayrefreshcount = _input_.readInt32();
/*  352 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  356 */           this.dayrestorevigorcount = _input_.readInt32();
/*  357 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  361 */           this.dayrestoresatiationcount = _input_.readInt32();
/*  362 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  366 */           this.dayttrainpetcount = _input_.readInt32();
/*  367 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  371 */           this.updatetime = _input_.readInt64();
/*  372 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  376 */           this.homestate = _input_.readInt32();
/*  377 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  381 */           int _k_ = 0;
/*  382 */           _k_ = _input_.readInt32();
/*  383 */           int readTag = _input_.readTag();
/*  384 */           if (80 != readTag)
/*      */           {
/*  386 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  388 */           int _v_ = 0;
/*  389 */           _v_ = _input_.readInt32();
/*  390 */           this.canbuyitem2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  391 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  395 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  397 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  406 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  410 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  412 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HomeOperate copy()
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     return new HomeOperate(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HomeOperate toData()
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.HomeOperate toBean()
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     return new HomeOperate(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HomeOperate toDataIf()
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*  439 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.HomeOperate toBeanIf()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.FurnitureUuIds> getOwnfurnitures()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     return Logs.logMap(new LogKey(this, "ownfurnitures"), this.ownfurnitures);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.FurnitureUuIds> getOwnfurnituresAsData()
/*      */   {
/*  467 */     _xdb_verify_unsafe_();
/*      */     
/*  469 */     HomeOperate _o_ = this;
/*  470 */     Map<Integer, xbean.FurnitureUuIds> ownfurnitures = new HashMap();
/*  471 */     for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : _o_.ownfurnitures.entrySet())
/*  472 */       ownfurnitures.put(_e_.getKey(), new FurnitureUuIds.Data((xbean.FurnitureUuIds)_e_.getValue()));
/*  473 */     return ownfurnitures;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getCanbuyitems()
/*      */   {
/*  480 */     _xdb_verify_unsafe_();
/*  481 */     return Logs.logSet(new LogKey(this, "canbuyitems"), this.canbuyitems);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getCanbuyitemsAsData()
/*      */   {
/*  487 */     _xdb_verify_unsafe_();
/*      */     
/*  489 */     HomeOperate _o_ = this;
/*  490 */     Set<Integer> canbuyitems = new SetX();
/*  491 */     canbuyitems.addAll(_o_.canbuyitems);
/*  492 */     return canbuyitems;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getItem2buynum()
/*      */   {
/*  499 */     _xdb_verify_unsafe_();
/*  500 */     return Logs.logMap(new LogKey(this, "item2buynum"), this.item2buynum);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getItem2buynumAsData()
/*      */   {
/*  507 */     _xdb_verify_unsafe_();
/*      */     
/*  509 */     HomeOperate _o_ = this;
/*  510 */     Map<Integer, Integer> item2buynum = new HashMap();
/*  511 */     for (Map.Entry<Integer, Integer> _e_ : _o_.item2buynum.entrySet())
/*  512 */       item2buynum.put(_e_.getKey(), _e_.getValue());
/*  513 */     return item2buynum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDayrefreshcount()
/*      */   {
/*  520 */     _xdb_verify_unsafe_();
/*  521 */     return this.dayrefreshcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDayrestorevigorcount()
/*      */   {
/*  528 */     _xdb_verify_unsafe_();
/*  529 */     return this.dayrestorevigorcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDayrestoresatiationcount()
/*      */   {
/*  536 */     _xdb_verify_unsafe_();
/*  537 */     return this.dayrestoresatiationcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDayttrainpetcount()
/*      */   {
/*  544 */     _xdb_verify_unsafe_();
/*  545 */     return this.dayttrainpetcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getUpdatetime()
/*      */   {
/*  552 */     _xdb_verify_unsafe_();
/*  553 */     return this.updatetime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHomestate()
/*      */   {
/*  560 */     _xdb_verify_unsafe_();
/*  561 */     return this.homestate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getCanbuyitem2num()
/*      */   {
/*  568 */     _xdb_verify_unsafe_();
/*  569 */     return Logs.logMap(new LogKey(this, "canbuyitem2num"), this.canbuyitem2num);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getCanbuyitem2numAsData()
/*      */   {
/*  576 */     _xdb_verify_unsafe_();
/*      */     
/*  578 */     HomeOperate _o_ = this;
/*  579 */     Map<Integer, Integer> canbuyitem2num = new HashMap();
/*  580 */     for (Map.Entry<Integer, Integer> _e_ : _o_.canbuyitem2num.entrySet())
/*  581 */       canbuyitem2num.put(_e_.getKey(), _e_.getValue());
/*  582 */     return canbuyitem2num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDayrefreshcount(int _v_)
/*      */   {
/*  589 */     _xdb_verify_unsafe_();
/*  590 */     Logs.logIf(new LogKey(this, "dayrefreshcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  594 */         new LogInt(this, HomeOperate.this.dayrefreshcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  598 */             HomeOperate.this.dayrefreshcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  602 */     });
/*  603 */     this.dayrefreshcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDayrestorevigorcount(int _v_)
/*      */   {
/*  610 */     _xdb_verify_unsafe_();
/*  611 */     Logs.logIf(new LogKey(this, "dayrestorevigorcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  615 */         new LogInt(this, HomeOperate.this.dayrestorevigorcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  619 */             HomeOperate.this.dayrestorevigorcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  623 */     });
/*  624 */     this.dayrestorevigorcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDayrestoresatiationcount(int _v_)
/*      */   {
/*  631 */     _xdb_verify_unsafe_();
/*  632 */     Logs.logIf(new LogKey(this, "dayrestoresatiationcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  636 */         new LogInt(this, HomeOperate.this.dayrestoresatiationcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  640 */             HomeOperate.this.dayrestoresatiationcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  644 */     });
/*  645 */     this.dayrestoresatiationcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDayttrainpetcount(int _v_)
/*      */   {
/*  652 */     _xdb_verify_unsafe_();
/*  653 */     Logs.logIf(new LogKey(this, "dayttrainpetcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  657 */         new LogInt(this, HomeOperate.this.dayttrainpetcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  661 */             HomeOperate.this.dayttrainpetcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  665 */     });
/*  666 */     this.dayttrainpetcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUpdatetime(long _v_)
/*      */   {
/*  673 */     _xdb_verify_unsafe_();
/*  674 */     Logs.logIf(new LogKey(this, "updatetime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  678 */         new xdb.logs.LogLong(this, HomeOperate.this.updatetime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  682 */             HomeOperate.this.updatetime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  686 */     });
/*  687 */     this.updatetime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHomestate(int _v_)
/*      */   {
/*  694 */     _xdb_verify_unsafe_();
/*  695 */     Logs.logIf(new LogKey(this, "homestate")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  699 */         new LogInt(this, HomeOperate.this.homestate)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  703 */             HomeOperate.this.homestate = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  707 */     });
/*  708 */     this.homestate = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  714 */     _xdb_verify_unsafe_();
/*  715 */     HomeOperate _o_ = null;
/*  716 */     if ((_o1_ instanceof HomeOperate)) { _o_ = (HomeOperate)_o1_;
/*  717 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  718 */       return false;
/*  719 */     if (!this.ownfurnitures.equals(_o_.ownfurnitures)) return false;
/*  720 */     if (!this.canbuyitems.equals(_o_.canbuyitems)) return false;
/*  721 */     if (!this.item2buynum.equals(_o_.item2buynum)) return false;
/*  722 */     if (this.dayrefreshcount != _o_.dayrefreshcount) return false;
/*  723 */     if (this.dayrestorevigorcount != _o_.dayrestorevigorcount) return false;
/*  724 */     if (this.dayrestoresatiationcount != _o_.dayrestoresatiationcount) return false;
/*  725 */     if (this.dayttrainpetcount != _o_.dayttrainpetcount) return false;
/*  726 */     if (this.updatetime != _o_.updatetime) return false;
/*  727 */     if (this.homestate != _o_.homestate) return false;
/*  728 */     if (!this.canbuyitem2num.equals(_o_.canbuyitem2num)) return false;
/*  729 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  735 */     _xdb_verify_unsafe_();
/*  736 */     int _h_ = 0;
/*  737 */     _h_ += this.ownfurnitures.hashCode();
/*  738 */     _h_ += this.canbuyitems.hashCode();
/*  739 */     _h_ += this.item2buynum.hashCode();
/*  740 */     _h_ += this.dayrefreshcount;
/*  741 */     _h_ += this.dayrestorevigorcount;
/*  742 */     _h_ += this.dayrestoresatiationcount;
/*  743 */     _h_ += this.dayttrainpetcount;
/*  744 */     _h_ = (int)(_h_ + this.updatetime);
/*  745 */     _h_ += this.homestate;
/*  746 */     _h_ += this.canbuyitem2num.hashCode();
/*  747 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  753 */     _xdb_verify_unsafe_();
/*  754 */     StringBuilder _sb_ = new StringBuilder();
/*  755 */     _sb_.append("(");
/*  756 */     _sb_.append(this.ownfurnitures);
/*  757 */     _sb_.append(",");
/*  758 */     _sb_.append(this.canbuyitems);
/*  759 */     _sb_.append(",");
/*  760 */     _sb_.append(this.item2buynum);
/*  761 */     _sb_.append(",");
/*  762 */     _sb_.append(this.dayrefreshcount);
/*  763 */     _sb_.append(",");
/*  764 */     _sb_.append(this.dayrestorevigorcount);
/*  765 */     _sb_.append(",");
/*  766 */     _sb_.append(this.dayrestoresatiationcount);
/*  767 */     _sb_.append(",");
/*  768 */     _sb_.append(this.dayttrainpetcount);
/*  769 */     _sb_.append(",");
/*  770 */     _sb_.append(this.updatetime);
/*  771 */     _sb_.append(",");
/*  772 */     _sb_.append(this.homestate);
/*  773 */     _sb_.append(",");
/*  774 */     _sb_.append(this.canbuyitem2num);
/*  775 */     _sb_.append(")");
/*  776 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  782 */     ListenableBean lb = new ListenableBean();
/*  783 */     lb.add(new xdb.logs.ListenableMap().setVarName("ownfurnitures"));
/*  784 */     lb.add(new xdb.logs.ListenableSet().setVarName("canbuyitems"));
/*  785 */     lb.add(new xdb.logs.ListenableMap().setVarName("item2buynum"));
/*  786 */     lb.add(new ListenableChanged().setVarName("dayrefreshcount"));
/*  787 */     lb.add(new ListenableChanged().setVarName("dayrestorevigorcount"));
/*  788 */     lb.add(new ListenableChanged().setVarName("dayrestoresatiationcount"));
/*  789 */     lb.add(new ListenableChanged().setVarName("dayttrainpetcount"));
/*  790 */     lb.add(new ListenableChanged().setVarName("updatetime"));
/*  791 */     lb.add(new ListenableChanged().setVarName("homestate"));
/*  792 */     lb.add(new xdb.logs.ListenableMap().setVarName("canbuyitem2num"));
/*  793 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.HomeOperate {
/*      */     private Const() {}
/*      */     
/*      */     HomeOperate nThis() {
/*  800 */       return HomeOperate.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  806 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeOperate copy()
/*      */     {
/*  812 */       return HomeOperate.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeOperate toData()
/*      */     {
/*  818 */       return HomeOperate.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.HomeOperate toBean()
/*      */     {
/*  823 */       return HomeOperate.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeOperate toDataIf()
/*      */     {
/*  829 */       return HomeOperate.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.HomeOperate toBeanIf()
/*      */     {
/*  834 */       return HomeOperate.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FurnitureUuIds> getOwnfurnitures()
/*      */     {
/*  841 */       HomeOperate.this._xdb_verify_unsafe_();
/*  842 */       return xdb.Consts.constMap(HomeOperate.this.ownfurnitures);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FurnitureUuIds> getOwnfurnituresAsData()
/*      */     {
/*  849 */       HomeOperate.this._xdb_verify_unsafe_();
/*      */       
/*  851 */       HomeOperate _o_ = HomeOperate.this;
/*  852 */       Map<Integer, xbean.FurnitureUuIds> ownfurnitures = new HashMap();
/*  853 */       for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : _o_.ownfurnitures.entrySet())
/*  854 */         ownfurnitures.put(_e_.getKey(), new FurnitureUuIds.Data((xbean.FurnitureUuIds)_e_.getValue()));
/*  855 */       return ownfurnitures;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getCanbuyitems()
/*      */     {
/*  862 */       HomeOperate.this._xdb_verify_unsafe_();
/*  863 */       return xdb.Consts.constSet(HomeOperate.this.canbuyitems);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getCanbuyitemsAsData()
/*      */     {
/*  869 */       HomeOperate.this._xdb_verify_unsafe_();
/*      */       
/*  871 */       HomeOperate _o_ = HomeOperate.this;
/*  872 */       Set<Integer> canbuyitems = new SetX();
/*  873 */       canbuyitems.addAll(_o_.canbuyitems);
/*  874 */       return canbuyitems;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItem2buynum()
/*      */     {
/*  881 */       HomeOperate.this._xdb_verify_unsafe_();
/*  882 */       return xdb.Consts.constMap(HomeOperate.this.item2buynum);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItem2buynumAsData()
/*      */     {
/*  889 */       HomeOperate.this._xdb_verify_unsafe_();
/*      */       
/*  891 */       HomeOperate _o_ = HomeOperate.this;
/*  892 */       Map<Integer, Integer> item2buynum = new HashMap();
/*  893 */       for (Map.Entry<Integer, Integer> _e_ : _o_.item2buynum.entrySet())
/*  894 */         item2buynum.put(_e_.getKey(), _e_.getValue());
/*  895 */       return item2buynum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDayrefreshcount()
/*      */     {
/*  902 */       HomeOperate.this._xdb_verify_unsafe_();
/*  903 */       return HomeOperate.this.dayrefreshcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDayrestorevigorcount()
/*      */     {
/*  910 */       HomeOperate.this._xdb_verify_unsafe_();
/*  911 */       return HomeOperate.this.dayrestorevigorcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDayrestoresatiationcount()
/*      */     {
/*  918 */       HomeOperate.this._xdb_verify_unsafe_();
/*  919 */       return HomeOperate.this.dayrestoresatiationcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDayttrainpetcount()
/*      */     {
/*  926 */       HomeOperate.this._xdb_verify_unsafe_();
/*  927 */       return HomeOperate.this.dayttrainpetcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getUpdatetime()
/*      */     {
/*  934 */       HomeOperate.this._xdb_verify_unsafe_();
/*  935 */       return HomeOperate.this.updatetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHomestate()
/*      */     {
/*  942 */       HomeOperate.this._xdb_verify_unsafe_();
/*  943 */       return HomeOperate.this.homestate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getCanbuyitem2num()
/*      */     {
/*  950 */       HomeOperate.this._xdb_verify_unsafe_();
/*  951 */       return xdb.Consts.constMap(HomeOperate.this.canbuyitem2num);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getCanbuyitem2numAsData()
/*      */     {
/*  958 */       HomeOperate.this._xdb_verify_unsafe_();
/*      */       
/*  960 */       HomeOperate _o_ = HomeOperate.this;
/*  961 */       Map<Integer, Integer> canbuyitem2num = new HashMap();
/*  962 */       for (Map.Entry<Integer, Integer> _e_ : _o_.canbuyitem2num.entrySet())
/*  963 */         canbuyitem2num.put(_e_.getKey(), _e_.getValue());
/*  964 */       return canbuyitem2num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDayrefreshcount(int _v_)
/*      */     {
/*  971 */       HomeOperate.this._xdb_verify_unsafe_();
/*  972 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDayrestorevigorcount(int _v_)
/*      */     {
/*  979 */       HomeOperate.this._xdb_verify_unsafe_();
/*  980 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDayrestoresatiationcount(int _v_)
/*      */     {
/*  987 */       HomeOperate.this._xdb_verify_unsafe_();
/*  988 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDayttrainpetcount(int _v_)
/*      */     {
/*  995 */       HomeOperate.this._xdb_verify_unsafe_();
/*  996 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdatetime(long _v_)
/*      */     {
/* 1003 */       HomeOperate.this._xdb_verify_unsafe_();
/* 1004 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHomestate(int _v_)
/*      */     {
/* 1011 */       HomeOperate.this._xdb_verify_unsafe_();
/* 1012 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/* 1018 */       HomeOperate.this._xdb_verify_unsafe_();
/* 1019 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1025 */       HomeOperate.this._xdb_verify_unsafe_();
/* 1026 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1032 */       return HomeOperate.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1038 */       return HomeOperate.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1044 */       HomeOperate.this._xdb_verify_unsafe_();
/* 1045 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1051 */       return HomeOperate.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1057 */       return HomeOperate.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1063 */       HomeOperate.this._xdb_verify_unsafe_();
/* 1064 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/* 1070 */       return HomeOperate.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1076 */       return HomeOperate.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1082 */       return HomeOperate.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1088 */       return HomeOperate.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1094 */       return HomeOperate.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1100 */       return HomeOperate.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1106 */       return HomeOperate.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.HomeOperate
/*      */   {
/*      */     private HashMap<Integer, xbean.FurnitureUuIds> ownfurnitures;
/*      */     
/*      */     private HashSet<Integer> canbuyitems;
/*      */     
/*      */     private HashMap<Integer, Integer> item2buynum;
/*      */     
/*      */     private int dayrefreshcount;
/*      */     
/*      */     private int dayrestorevigorcount;
/*      */     
/*      */     private int dayrestoresatiationcount;
/*      */     
/*      */     private int dayttrainpetcount;
/*      */     
/*      */     private long updatetime;
/*      */     
/*      */     private int homestate;
/*      */     
/*      */     private HashMap<Integer, Integer> canbuyitem2num;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1136 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1141 */       this.ownfurnitures = new HashMap();
/* 1142 */       this.canbuyitems = new HashSet();
/* 1143 */       this.item2buynum = new HashMap();
/* 1144 */       this.dayrefreshcount = 0;
/* 1145 */       this.dayrestorevigorcount = 0;
/* 1146 */       this.dayrestoresatiationcount = 0;
/* 1147 */       this.dayttrainpetcount = 0;
/* 1148 */       this.updatetime = 0L;
/* 1149 */       this.homestate = 2;
/* 1150 */       this.canbuyitem2num = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.HomeOperate _o1_)
/*      */     {
/* 1155 */       if ((_o1_ instanceof HomeOperate)) { assign((HomeOperate)_o1_);
/* 1156 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1157 */       } else if ((_o1_ instanceof HomeOperate.Const)) assign(((HomeOperate.Const)_o1_).nThis()); else {
/* 1158 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(HomeOperate _o_) {
/* 1163 */       this.ownfurnitures = new HashMap();
/* 1164 */       for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : _o_.ownfurnitures.entrySet())
/* 1165 */         this.ownfurnitures.put(_e_.getKey(), new FurnitureUuIds.Data((xbean.FurnitureUuIds)_e_.getValue()));
/* 1166 */       this.canbuyitems = new HashSet();
/* 1167 */       this.canbuyitems.addAll(_o_.canbuyitems);
/* 1168 */       this.item2buynum = new HashMap();
/* 1169 */       for (Map.Entry<Integer, Integer> _e_ : _o_.item2buynum.entrySet())
/* 1170 */         this.item2buynum.put(_e_.getKey(), _e_.getValue());
/* 1171 */       this.dayrefreshcount = _o_.dayrefreshcount;
/* 1172 */       this.dayrestorevigorcount = _o_.dayrestorevigorcount;
/* 1173 */       this.dayrestoresatiationcount = _o_.dayrestoresatiationcount;
/* 1174 */       this.dayttrainpetcount = _o_.dayttrainpetcount;
/* 1175 */       this.updatetime = _o_.updatetime;
/* 1176 */       this.homestate = _o_.homestate;
/* 1177 */       this.canbuyitem2num = new HashMap();
/* 1178 */       for (Map.Entry<Integer, Integer> _e_ : _o_.canbuyitem2num.entrySet()) {
/* 1179 */         this.canbuyitem2num.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 1184 */       this.ownfurnitures = new HashMap();
/* 1185 */       for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : _o_.ownfurnitures.entrySet())
/* 1186 */         this.ownfurnitures.put(_e_.getKey(), new FurnitureUuIds.Data((xbean.FurnitureUuIds)_e_.getValue()));
/* 1187 */       this.canbuyitems = new HashSet();
/* 1188 */       this.canbuyitems.addAll(_o_.canbuyitems);
/* 1189 */       this.item2buynum = new HashMap();
/* 1190 */       for (Map.Entry<Integer, Integer> _e_ : _o_.item2buynum.entrySet())
/* 1191 */         this.item2buynum.put(_e_.getKey(), _e_.getValue());
/* 1192 */       this.dayrefreshcount = _o_.dayrefreshcount;
/* 1193 */       this.dayrestorevigorcount = _o_.dayrestorevigorcount;
/* 1194 */       this.dayrestoresatiationcount = _o_.dayrestoresatiationcount;
/* 1195 */       this.dayttrainpetcount = _o_.dayttrainpetcount;
/* 1196 */       this.updatetime = _o_.updatetime;
/* 1197 */       this.homestate = _o_.homestate;
/* 1198 */       this.canbuyitem2num = new HashMap();
/* 1199 */       for (Map.Entry<Integer, Integer> _e_ : _o_.canbuyitem2num.entrySet()) {
/* 1200 */         this.canbuyitem2num.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1206 */       _os_.compact_uint32(this.ownfurnitures.size());
/* 1207 */       for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : this.ownfurnitures.entrySet())
/*      */       {
/* 1209 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1210 */         ((xbean.FurnitureUuIds)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1212 */       _os_.compact_uint32(this.canbuyitems.size());
/* 1213 */       for (Integer _v_ : this.canbuyitems)
/*      */       {
/* 1215 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1217 */       _os_.compact_uint32(this.item2buynum.size());
/* 1218 */       for (Map.Entry<Integer, Integer> _e_ : this.item2buynum.entrySet())
/*      */       {
/* 1220 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1221 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1223 */       _os_.marshal(this.dayrefreshcount);
/* 1224 */       _os_.marshal(this.dayrestorevigorcount);
/* 1225 */       _os_.marshal(this.dayrestoresatiationcount);
/* 1226 */       _os_.marshal(this.dayttrainpetcount);
/* 1227 */       _os_.marshal(this.updatetime);
/* 1228 */       _os_.marshal(this.homestate);
/* 1229 */       _os_.compact_uint32(this.canbuyitem2num.size());
/* 1230 */       for (Map.Entry<Integer, Integer> _e_ : this.canbuyitem2num.entrySet())
/*      */       {
/* 1232 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1233 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1235 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1242 */       int size = _os_.uncompact_uint32();
/* 1243 */       if (size >= 12)
/*      */       {
/* 1245 */         this.ownfurnitures = new HashMap(size * 2);
/*      */       }
/* 1247 */       for (; size > 0; size--)
/*      */       {
/* 1249 */         int _k_ = 0;
/* 1250 */         _k_ = _os_.unmarshal_int();
/* 1251 */         xbean.FurnitureUuIds _v_ = xbean.Pod.newFurnitureUuIdsData();
/* 1252 */         _v_.unmarshal(_os_);
/* 1253 */         this.ownfurnitures.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1256 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1258 */         int _v_ = 0;
/* 1259 */         _v_ = _os_.unmarshal_int();
/* 1260 */         this.canbuyitems.add(Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1263 */       int size = _os_.uncompact_uint32();
/* 1264 */       if (size >= 12)
/*      */       {
/* 1266 */         this.item2buynum = new HashMap(size * 2);
/*      */       }
/* 1268 */       for (; size > 0; size--)
/*      */       {
/* 1270 */         int _k_ = 0;
/* 1271 */         _k_ = _os_.unmarshal_int();
/* 1272 */         int _v_ = 0;
/* 1273 */         _v_ = _os_.unmarshal_int();
/* 1274 */         this.item2buynum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1277 */       this.dayrefreshcount = _os_.unmarshal_int();
/* 1278 */       this.dayrestorevigorcount = _os_.unmarshal_int();
/* 1279 */       this.dayrestoresatiationcount = _os_.unmarshal_int();
/* 1280 */       this.dayttrainpetcount = _os_.unmarshal_int();
/* 1281 */       this.updatetime = _os_.unmarshal_long();
/* 1282 */       this.homestate = _os_.unmarshal_int();
/*      */       
/* 1284 */       int size = _os_.uncompact_uint32();
/* 1285 */       if (size >= 12)
/*      */       {
/* 1287 */         this.canbuyitem2num = new HashMap(size * 2);
/*      */       }
/* 1289 */       for (; size > 0; size--)
/*      */       {
/* 1291 */         int _k_ = 0;
/* 1292 */         _k_ = _os_.unmarshal_int();
/* 1293 */         int _v_ = 0;
/* 1294 */         _v_ = _os_.unmarshal_int();
/* 1295 */         this.canbuyitem2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1298 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1304 */       int _size_ = 0;
/* 1305 */       for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : this.ownfurnitures.entrySet())
/*      */       {
/* 1307 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 1308 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1310 */       for (Integer _v_ : this.canbuyitems)
/*      */       {
/* 1312 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */       }
/* 1314 */       for (Map.Entry<Integer, Integer> _e_ : this.item2buynum.entrySet())
/*      */       {
/* 1316 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 1317 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1319 */       _size_ += CodedOutputStream.computeInt32Size(4, this.dayrefreshcount);
/* 1320 */       _size_ += CodedOutputStream.computeInt32Size(5, this.dayrestorevigorcount);
/* 1321 */       _size_ += CodedOutputStream.computeInt32Size(6, this.dayrestoresatiationcount);
/* 1322 */       _size_ += CodedOutputStream.computeInt32Size(7, this.dayttrainpetcount);
/* 1323 */       _size_ += CodedOutputStream.computeInt64Size(8, this.updatetime);
/* 1324 */       _size_ += CodedOutputStream.computeInt32Size(9, this.homestate);
/* 1325 */       for (Map.Entry<Integer, Integer> _e_ : this.canbuyitem2num.entrySet())
/*      */       {
/* 1327 */         _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getKey()).intValue());
/* 1328 */         _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1330 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1338 */         for (Map.Entry<Integer, xbean.FurnitureUuIds> _e_ : this.ownfurnitures.entrySet())
/*      */         {
/* 1340 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 1341 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1343 */         for (Integer _v_ : this.canbuyitems)
/*      */         {
/* 1345 */           _output_.writeInt32(2, _v_.intValue());
/*      */         }
/* 1347 */         for (Map.Entry<Integer, Integer> _e_ : this.item2buynum.entrySet())
/*      */         {
/* 1349 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 1350 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1352 */         _output_.writeInt32(4, this.dayrefreshcount);
/* 1353 */         _output_.writeInt32(5, this.dayrestorevigorcount);
/* 1354 */         _output_.writeInt32(6, this.dayrestoresatiationcount);
/* 1355 */         _output_.writeInt32(7, this.dayttrainpetcount);
/* 1356 */         _output_.writeInt64(8, this.updatetime);
/* 1357 */         _output_.writeInt32(9, this.homestate);
/* 1358 */         for (Map.Entry<Integer, Integer> _e_ : this.canbuyitem2num.entrySet())
/*      */         {
/* 1360 */           _output_.writeInt32(10, ((Integer)_e_.getKey()).intValue());
/* 1361 */           _output_.writeInt32(10, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1366 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1368 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1376 */         boolean done = false;
/* 1377 */         while (!done)
/*      */         {
/* 1379 */           int tag = _input_.readTag();
/* 1380 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1384 */             done = true;
/* 1385 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1389 */             int _k_ = 0;
/* 1390 */             _k_ = _input_.readInt32();
/* 1391 */             int readTag = _input_.readTag();
/* 1392 */             if (10 != readTag)
/*      */             {
/* 1394 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1396 */             xbean.FurnitureUuIds _v_ = xbean.Pod.newFurnitureUuIdsData();
/* 1397 */             _input_.readMessage(_v_);
/* 1398 */             this.ownfurnitures.put(Integer.valueOf(_k_), _v_);
/* 1399 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1403 */             int _v_ = 0;
/* 1404 */             _v_ = _input_.readInt32();
/* 1405 */             this.canbuyitems.add(Integer.valueOf(_v_));
/* 1406 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1410 */             int _k_ = 0;
/* 1411 */             _k_ = _input_.readInt32();
/* 1412 */             int readTag = _input_.readTag();
/* 1413 */             if (24 != readTag)
/*      */             {
/* 1415 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1417 */             int _v_ = 0;
/* 1418 */             _v_ = _input_.readInt32();
/* 1419 */             this.item2buynum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1420 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1424 */             this.dayrefreshcount = _input_.readInt32();
/* 1425 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1429 */             this.dayrestorevigorcount = _input_.readInt32();
/* 1430 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1434 */             this.dayrestoresatiationcount = _input_.readInt32();
/* 1435 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1439 */             this.dayttrainpetcount = _input_.readInt32();
/* 1440 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1444 */             this.updatetime = _input_.readInt64();
/* 1445 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1449 */             this.homestate = _input_.readInt32();
/* 1450 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1454 */             int _k_ = 0;
/* 1455 */             _k_ = _input_.readInt32();
/* 1456 */             int readTag = _input_.readTag();
/* 1457 */             if (80 != readTag)
/*      */             {
/* 1459 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1461 */             int _v_ = 0;
/* 1462 */             _v_ = _input_.readInt32();
/* 1463 */             this.canbuyitem2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1464 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1468 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1470 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1479 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1483 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1485 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeOperate copy()
/*      */     {
/* 1491 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeOperate toData()
/*      */     {
/* 1497 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.HomeOperate toBean()
/*      */     {
/* 1502 */       return new HomeOperate(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeOperate toDataIf()
/*      */     {
/* 1508 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.HomeOperate toBeanIf()
/*      */     {
/* 1513 */       return new HomeOperate(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1519 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1523 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1527 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1531 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1535 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1539 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1543 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FurnitureUuIds> getOwnfurnitures()
/*      */     {
/* 1550 */       return this.ownfurnitures;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FurnitureUuIds> getOwnfurnituresAsData()
/*      */     {
/* 1557 */       return this.ownfurnitures;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getCanbuyitems()
/*      */     {
/* 1564 */       return this.canbuyitems;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getCanbuyitemsAsData()
/*      */     {
/* 1571 */       return this.canbuyitems;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItem2buynum()
/*      */     {
/* 1578 */       return this.item2buynum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItem2buynumAsData()
/*      */     {
/* 1585 */       return this.item2buynum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDayrefreshcount()
/*      */     {
/* 1592 */       return this.dayrefreshcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDayrestorevigorcount()
/*      */     {
/* 1599 */       return this.dayrestorevigorcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDayrestoresatiationcount()
/*      */     {
/* 1606 */       return this.dayrestoresatiationcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDayttrainpetcount()
/*      */     {
/* 1613 */       return this.dayttrainpetcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getUpdatetime()
/*      */     {
/* 1620 */       return this.updatetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHomestate()
/*      */     {
/* 1627 */       return this.homestate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getCanbuyitem2num()
/*      */     {
/* 1634 */       return this.canbuyitem2num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getCanbuyitem2numAsData()
/*      */     {
/* 1641 */       return this.canbuyitem2num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDayrefreshcount(int _v_)
/*      */     {
/* 1648 */       this.dayrefreshcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDayrestorevigorcount(int _v_)
/*      */     {
/* 1655 */       this.dayrestorevigorcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDayrestoresatiationcount(int _v_)
/*      */     {
/* 1662 */       this.dayrestoresatiationcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDayttrainpetcount(int _v_)
/*      */     {
/* 1669 */       this.dayttrainpetcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdatetime(long _v_)
/*      */     {
/* 1676 */       this.updatetime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHomestate(int _v_)
/*      */     {
/* 1683 */       this.homestate = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1689 */       if (!(_o1_ instanceof Data)) return false;
/* 1690 */       Data _o_ = (Data)_o1_;
/* 1691 */       if (!this.ownfurnitures.equals(_o_.ownfurnitures)) return false;
/* 1692 */       if (!this.canbuyitems.equals(_o_.canbuyitems)) return false;
/* 1693 */       if (!this.item2buynum.equals(_o_.item2buynum)) return false;
/* 1694 */       if (this.dayrefreshcount != _o_.dayrefreshcount) return false;
/* 1695 */       if (this.dayrestorevigorcount != _o_.dayrestorevigorcount) return false;
/* 1696 */       if (this.dayrestoresatiationcount != _o_.dayrestoresatiationcount) return false;
/* 1697 */       if (this.dayttrainpetcount != _o_.dayttrainpetcount) return false;
/* 1698 */       if (this.updatetime != _o_.updatetime) return false;
/* 1699 */       if (this.homestate != _o_.homestate) return false;
/* 1700 */       if (!this.canbuyitem2num.equals(_o_.canbuyitem2num)) return false;
/* 1701 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1707 */       int _h_ = 0;
/* 1708 */       _h_ += this.ownfurnitures.hashCode();
/* 1709 */       _h_ += this.canbuyitems.hashCode();
/* 1710 */       _h_ += this.item2buynum.hashCode();
/* 1711 */       _h_ += this.dayrefreshcount;
/* 1712 */       _h_ += this.dayrestorevigorcount;
/* 1713 */       _h_ += this.dayrestoresatiationcount;
/* 1714 */       _h_ += this.dayttrainpetcount;
/* 1715 */       _h_ = (int)(_h_ + this.updatetime);
/* 1716 */       _h_ += this.homestate;
/* 1717 */       _h_ += this.canbuyitem2num.hashCode();
/* 1718 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1724 */       StringBuilder _sb_ = new StringBuilder();
/* 1725 */       _sb_.append("(");
/* 1726 */       _sb_.append(this.ownfurnitures);
/* 1727 */       _sb_.append(",");
/* 1728 */       _sb_.append(this.canbuyitems);
/* 1729 */       _sb_.append(",");
/* 1730 */       _sb_.append(this.item2buynum);
/* 1731 */       _sb_.append(",");
/* 1732 */       _sb_.append(this.dayrefreshcount);
/* 1733 */       _sb_.append(",");
/* 1734 */       _sb_.append(this.dayrestorevigorcount);
/* 1735 */       _sb_.append(",");
/* 1736 */       _sb_.append(this.dayrestoresatiationcount);
/* 1737 */       _sb_.append(",");
/* 1738 */       _sb_.append(this.dayttrainpetcount);
/* 1739 */       _sb_.append(",");
/* 1740 */       _sb_.append(this.updatetime);
/* 1741 */       _sb_.append(",");
/* 1742 */       _sb_.append(this.homestate);
/* 1743 */       _sb_.append(",");
/* 1744 */       _sb_.append(this.canbuyitem2num);
/* 1745 */       _sb_.append(")");
/* 1746 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\HomeOperate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */