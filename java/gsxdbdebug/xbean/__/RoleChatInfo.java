/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableMap;
/*      */ 
/*      */ public final class RoleChatInfo extends XBean implements xbean.RoleChatInfo
/*      */ {
/*      */   private HashMap<Integer, Long> channels;
/*      */   private HashMap<Long, xbean.ChatDataListBean> chatinfo;
/*      */   private HashMap<Integer, Integer> chatcfg;
/*      */   private int chat_room_type;
/*      */   private int chat_roomid;
/*      */   private HashMap<Integer, Long> secretchannels;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.channels.clear();
/*   29 */     this.chatinfo.clear();
/*   30 */     this.chatcfg.clear();
/*   31 */     this.chat_room_type = -1;
/*   32 */     this.chat_roomid = -1;
/*   33 */     this.secretchannels.clear();
/*      */   }
/*      */   
/*      */   RoleChatInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.channels = new HashMap();
/*   40 */     this.chatinfo = new HashMap();
/*   41 */     this.chatcfg = new HashMap();
/*   42 */     this.chat_room_type = -1;
/*   43 */     this.chat_roomid = -1;
/*   44 */     this.secretchannels = new HashMap();
/*      */   }
/*      */   
/*      */   public RoleChatInfo()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleChatInfo(RoleChatInfo _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleChatInfo(xbean.RoleChatInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof RoleChatInfo)) { assign((RoleChatInfo)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleChatInfo _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.channels = new HashMap();
/*   70 */     for (Map.Entry<Integer, Long> _e_ : _o_.channels.entrySet())
/*   71 */       this.channels.put(_e_.getKey(), _e_.getValue());
/*   72 */     this.chatinfo = new HashMap();
/*   73 */     for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : _o_.chatinfo.entrySet())
/*   74 */       this.chatinfo.put(_e_.getKey(), new ChatDataListBean((xbean.ChatDataListBean)_e_.getValue(), this, "chatinfo"));
/*   75 */     this.chatcfg = new HashMap();
/*   76 */     for (Map.Entry<Integer, Integer> _e_ : _o_.chatcfg.entrySet())
/*   77 */       this.chatcfg.put(_e_.getKey(), _e_.getValue());
/*   78 */     this.chat_room_type = _o_.chat_room_type;
/*   79 */     this.chat_roomid = _o_.chat_roomid;
/*   80 */     this.secretchannels = new HashMap();
/*   81 */     for (Map.Entry<Integer, Long> _e_ : _o_.secretchannels.entrySet()) {
/*   82 */       this.secretchannels.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   87 */     this.channels = new HashMap();
/*   88 */     for (Map.Entry<Integer, Long> _e_ : _o_.channels.entrySet())
/*   89 */       this.channels.put(_e_.getKey(), _e_.getValue());
/*   90 */     this.chatinfo = new HashMap();
/*   91 */     for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : _o_.chatinfo.entrySet())
/*   92 */       this.chatinfo.put(_e_.getKey(), new ChatDataListBean((xbean.ChatDataListBean)_e_.getValue(), this, "chatinfo"));
/*   93 */     this.chatcfg = new HashMap();
/*   94 */     for (Map.Entry<Integer, Integer> _e_ : _o_.chatcfg.entrySet())
/*   95 */       this.chatcfg.put(_e_.getKey(), _e_.getValue());
/*   96 */     this.chat_room_type = _o_.chat_room_type;
/*   97 */     this.chat_roomid = _o_.chat_roomid;
/*   98 */     this.secretchannels = new HashMap();
/*   99 */     for (Map.Entry<Integer, Long> _e_ : _o_.secretchannels.entrySet()) {
/*  100 */       this.secretchannels.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  106 */     _xdb_verify_unsafe_();
/*  107 */     _os_.compact_uint32(this.channels.size());
/*  108 */     for (Map.Entry<Integer, Long> _e_ : this.channels.entrySet())
/*      */     {
/*  110 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  111 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  113 */     _os_.compact_uint32(this.chatinfo.size());
/*  114 */     for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : this.chatinfo.entrySet())
/*      */     {
/*  116 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  117 */       ((xbean.ChatDataListBean)_e_.getValue()).marshal(_os_);
/*      */     }
/*  119 */     _os_.compact_uint32(this.chatcfg.size());
/*  120 */     for (Map.Entry<Integer, Integer> _e_ : this.chatcfg.entrySet())
/*      */     {
/*  122 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  123 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  125 */     _os_.marshal(this.chat_room_type);
/*  126 */     _os_.marshal(this.chat_roomid);
/*  127 */     _os_.compact_uint32(this.secretchannels.size());
/*  128 */     for (Map.Entry<Integer, Long> _e_ : this.secretchannels.entrySet())
/*      */     {
/*  130 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  131 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  133 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  139 */     _xdb_verify_unsafe_();
/*      */     
/*  141 */     int size = _os_.uncompact_uint32();
/*  142 */     if (size >= 12)
/*      */     {
/*  144 */       this.channels = new HashMap(size * 2);
/*      */     }
/*  146 */     for (; size > 0; size--)
/*      */     {
/*  148 */       int _k_ = 0;
/*  149 */       _k_ = _os_.unmarshal_int();
/*  150 */       long _v_ = 0L;
/*  151 */       _v_ = _os_.unmarshal_long();
/*  152 */       this.channels.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  156 */     int size = _os_.uncompact_uint32();
/*  157 */     if (size >= 12)
/*      */     {
/*  159 */       this.chatinfo = new HashMap(size * 2);
/*      */     }
/*  161 */     for (; size > 0; size--)
/*      */     {
/*  163 */       long _k_ = 0L;
/*  164 */       _k_ = _os_.unmarshal_long();
/*  165 */       xbean.ChatDataListBean _v_ = new ChatDataListBean(0, this, "chatinfo");
/*  166 */       _v_.unmarshal(_os_);
/*  167 */       this.chatinfo.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  171 */     int size = _os_.uncompact_uint32();
/*  172 */     if (size >= 12)
/*      */     {
/*  174 */       this.chatcfg = new HashMap(size * 2);
/*      */     }
/*  176 */     for (; size > 0; size--)
/*      */     {
/*  178 */       int _k_ = 0;
/*  179 */       _k_ = _os_.unmarshal_int();
/*  180 */       int _v_ = 0;
/*  181 */       _v_ = _os_.unmarshal_int();
/*  182 */       this.chatcfg.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  185 */     this.chat_room_type = _os_.unmarshal_int();
/*  186 */     this.chat_roomid = _os_.unmarshal_int();
/*      */     
/*  188 */     int size = _os_.uncompact_uint32();
/*  189 */     if (size >= 12)
/*      */     {
/*  191 */       this.secretchannels = new HashMap(size * 2);
/*      */     }
/*  193 */     for (; size > 0; size--)
/*      */     {
/*  195 */       int _k_ = 0;
/*  196 */       _k_ = _os_.unmarshal_int();
/*  197 */       long _v_ = 0L;
/*  198 */       _v_ = _os_.unmarshal_long();
/*  199 */       this.secretchannels.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*  202 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  208 */     _xdb_verify_unsafe_();
/*  209 */     int _size_ = 0;
/*  210 */     for (Map.Entry<Integer, Long> _e_ : this.channels.entrySet())
/*      */     {
/*  212 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  213 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  215 */     for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : this.chatinfo.entrySet())
/*      */     {
/*  217 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  218 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */     }
/*  220 */     for (Map.Entry<Integer, Integer> _e_ : this.chatcfg.entrySet())
/*      */     {
/*  222 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  223 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  225 */     _size_ += CodedOutputStream.computeInt32Size(4, this.chat_room_type);
/*  226 */     _size_ += CodedOutputStream.computeInt32Size(5, this.chat_roomid);
/*  227 */     for (Map.Entry<Integer, Long> _e_ : this.secretchannels.entrySet())
/*      */     {
/*  229 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  230 */       _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  232 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  238 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  241 */       for (Map.Entry<Integer, Long> _e_ : this.channels.entrySet())
/*      */       {
/*  243 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  244 */         _output_.writeInt64(1, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  246 */       for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : this.chatinfo.entrySet())
/*      */       {
/*  248 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  249 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  251 */       for (Map.Entry<Integer, Integer> _e_ : this.chatcfg.entrySet())
/*      */       {
/*  253 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  254 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  256 */       _output_.writeInt32(4, this.chat_room_type);
/*  257 */       _output_.writeInt32(5, this.chat_roomid);
/*  258 */       for (Map.Entry<Integer, Long> _e_ : this.secretchannels.entrySet())
/*      */       {
/*  260 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  261 */         _output_.writeInt64(6, ((Long)_e_.getValue()).longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  266 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  268 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  277 */       boolean done = false;
/*  278 */       while (!done)
/*      */       {
/*  280 */         int tag = _input_.readTag();
/*  281 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  285 */           done = true;
/*  286 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  290 */           int _k_ = 0;
/*  291 */           _k_ = _input_.readInt32();
/*  292 */           int readTag = _input_.readTag();
/*  293 */           if (8 != readTag)
/*      */           {
/*  295 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  297 */           long _v_ = 0L;
/*  298 */           _v_ = _input_.readInt64();
/*  299 */           this.channels.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*  300 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  304 */           long _k_ = 0L;
/*  305 */           _k_ = _input_.readInt64();
/*  306 */           int readTag = _input_.readTag();
/*  307 */           if (18 != readTag)
/*      */           {
/*  309 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  311 */           xbean.ChatDataListBean _v_ = new ChatDataListBean(0, this, "chatinfo");
/*  312 */           _input_.readMessage(_v_);
/*  313 */           this.chatinfo.put(Long.valueOf(_k_), _v_);
/*  314 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  318 */           int _k_ = 0;
/*  319 */           _k_ = _input_.readInt32();
/*  320 */           int readTag = _input_.readTag();
/*  321 */           if (24 != readTag)
/*      */           {
/*  323 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  325 */           int _v_ = 0;
/*  326 */           _v_ = _input_.readInt32();
/*  327 */           this.chatcfg.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  328 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  332 */           this.chat_room_type = _input_.readInt32();
/*  333 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  337 */           this.chat_roomid = _input_.readInt32();
/*  338 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  342 */           int _k_ = 0;
/*  343 */           _k_ = _input_.readInt32();
/*  344 */           int readTag = _input_.readTag();
/*  345 */           if (48 != readTag)
/*      */           {
/*  347 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  349 */           long _v_ = 0L;
/*  350 */           _v_ = _input_.readInt64();
/*  351 */           this.secretchannels.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*  352 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  356 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  358 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  367 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  371 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  373 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleChatInfo copy()
/*      */   {
/*  379 */     _xdb_verify_unsafe_();
/*  380 */     return new RoleChatInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleChatInfo toData()
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleChatInfo toBean()
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*  393 */     return new RoleChatInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleChatInfo toDataIf()
/*      */   {
/*  399 */     _xdb_verify_unsafe_();
/*  400 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleChatInfo toBeanIf()
/*      */   {
/*  405 */     _xdb_verify_unsafe_();
/*  406 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*  413 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getChannels()
/*      */   {
/*  420 */     _xdb_verify_unsafe_();
/*  421 */     return Logs.logMap(new LogKey(this, "channels"), this.channels);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getChannelsAsData()
/*      */   {
/*  428 */     _xdb_verify_unsafe_();
/*      */     
/*  430 */     RoleChatInfo _o_ = this;
/*  431 */     Map<Integer, Long> channels = new HashMap();
/*  432 */     for (Map.Entry<Integer, Long> _e_ : _o_.channels.entrySet())
/*  433 */       channels.put(_e_.getKey(), _e_.getValue());
/*  434 */     return channels;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ChatDataListBean> getChatinfo()
/*      */   {
/*  441 */     _xdb_verify_unsafe_();
/*  442 */     return Logs.logMap(new LogKey(this, "chatinfo"), this.chatinfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ChatDataListBean> getChatinfoAsData()
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*      */     
/*  451 */     RoleChatInfo _o_ = this;
/*  452 */     Map<Long, xbean.ChatDataListBean> chatinfo = new HashMap();
/*  453 */     for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : _o_.chatinfo.entrySet())
/*  454 */       chatinfo.put(_e_.getKey(), new ChatDataListBean.Data((xbean.ChatDataListBean)_e_.getValue()));
/*  455 */     return chatinfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getChatcfg()
/*      */   {
/*  462 */     _xdb_verify_unsafe_();
/*  463 */     return Logs.logMap(new LogKey(this, "chatcfg"), this.chatcfg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getChatcfgAsData()
/*      */   {
/*  470 */     _xdb_verify_unsafe_();
/*      */     
/*  472 */     RoleChatInfo _o_ = this;
/*  473 */     Map<Integer, Integer> chatcfg = new HashMap();
/*  474 */     for (Map.Entry<Integer, Integer> _e_ : _o_.chatcfg.entrySet())
/*  475 */       chatcfg.put(_e_.getKey(), _e_.getValue());
/*  476 */     return chatcfg;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getChat_room_type()
/*      */   {
/*  483 */     _xdb_verify_unsafe_();
/*  484 */     return this.chat_room_type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getChat_roomid()
/*      */   {
/*  491 */     _xdb_verify_unsafe_();
/*  492 */     return this.chat_roomid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getSecretchannels()
/*      */   {
/*  499 */     _xdb_verify_unsafe_();
/*  500 */     return Logs.logMap(new LogKey(this, "secretchannels"), this.secretchannels);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getSecretchannelsAsData()
/*      */   {
/*  507 */     _xdb_verify_unsafe_();
/*      */     
/*  509 */     RoleChatInfo _o_ = this;
/*  510 */     Map<Integer, Long> secretchannels = new HashMap();
/*  511 */     for (Map.Entry<Integer, Long> _e_ : _o_.secretchannels.entrySet())
/*  512 */       secretchannels.put(_e_.getKey(), _e_.getValue());
/*  513 */     return secretchannels;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChat_room_type(int _v_)
/*      */   {
/*  520 */     _xdb_verify_unsafe_();
/*  521 */     Logs.logIf(new LogKey(this, "chat_room_type")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  525 */         new xdb.logs.LogInt(this, RoleChatInfo.this.chat_room_type)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  529 */             RoleChatInfo.this.chat_room_type = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  533 */     });
/*  534 */     this.chat_room_type = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChat_roomid(int _v_)
/*      */   {
/*  541 */     _xdb_verify_unsafe_();
/*  542 */     Logs.logIf(new LogKey(this, "chat_roomid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  546 */         new xdb.logs.LogInt(this, RoleChatInfo.this.chat_roomid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  550 */             RoleChatInfo.this.chat_roomid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  554 */     });
/*  555 */     this.chat_roomid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  561 */     _xdb_verify_unsafe_();
/*  562 */     RoleChatInfo _o_ = null;
/*  563 */     if ((_o1_ instanceof RoleChatInfo)) { _o_ = (RoleChatInfo)_o1_;
/*  564 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  565 */       return false;
/*  566 */     if (!this.channels.equals(_o_.channels)) return false;
/*  567 */     if (!this.chatinfo.equals(_o_.chatinfo)) return false;
/*  568 */     if (!this.chatcfg.equals(_o_.chatcfg)) return false;
/*  569 */     if (this.chat_room_type != _o_.chat_room_type) return false;
/*  570 */     if (this.chat_roomid != _o_.chat_roomid) return false;
/*  571 */     if (!this.secretchannels.equals(_o_.secretchannels)) return false;
/*  572 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  578 */     _xdb_verify_unsafe_();
/*  579 */     int _h_ = 0;
/*  580 */     _h_ += this.channels.hashCode();
/*  581 */     _h_ += this.chatinfo.hashCode();
/*  582 */     _h_ += this.chatcfg.hashCode();
/*  583 */     _h_ += this.chat_room_type;
/*  584 */     _h_ += this.chat_roomid;
/*  585 */     _h_ += this.secretchannels.hashCode();
/*  586 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  592 */     _xdb_verify_unsafe_();
/*  593 */     StringBuilder _sb_ = new StringBuilder();
/*  594 */     _sb_.append("(");
/*  595 */     _sb_.append(this.channels);
/*  596 */     _sb_.append(",");
/*  597 */     _sb_.append(this.chatinfo);
/*  598 */     _sb_.append(",");
/*  599 */     _sb_.append(this.chatcfg);
/*  600 */     _sb_.append(",");
/*  601 */     _sb_.append(this.chat_room_type);
/*  602 */     _sb_.append(",");
/*  603 */     _sb_.append(this.chat_roomid);
/*  604 */     _sb_.append(",");
/*  605 */     _sb_.append(this.secretchannels);
/*  606 */     _sb_.append(")");
/*  607 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  613 */     ListenableBean lb = new ListenableBean();
/*  614 */     lb.add(new ListenableMap().setVarName("channels"));
/*  615 */     lb.add(new ListenableMap().setVarName("chatinfo"));
/*  616 */     lb.add(new ListenableMap().setVarName("chatcfg"));
/*  617 */     lb.add(new xdb.logs.ListenableChanged().setVarName("chat_room_type"));
/*  618 */     lb.add(new xdb.logs.ListenableChanged().setVarName("chat_roomid"));
/*  619 */     lb.add(new ListenableMap().setVarName("secretchannels"));
/*  620 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleChatInfo {
/*      */     private Const() {}
/*      */     
/*      */     RoleChatInfo nThis() {
/*  627 */       return RoleChatInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  633 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleChatInfo copy()
/*      */     {
/*  639 */       return RoleChatInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleChatInfo toData()
/*      */     {
/*  645 */       return RoleChatInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleChatInfo toBean()
/*      */     {
/*  650 */       return RoleChatInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleChatInfo toDataIf()
/*      */     {
/*  656 */       return RoleChatInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleChatInfo toBeanIf()
/*      */     {
/*  661 */       return RoleChatInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getChannels()
/*      */     {
/*  668 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  669 */       return xdb.Consts.constMap(RoleChatInfo.this.channels);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getChannelsAsData()
/*      */     {
/*  676 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*      */       
/*  678 */       RoleChatInfo _o_ = RoleChatInfo.this;
/*  679 */       Map<Integer, Long> channels = new HashMap();
/*  680 */       for (Map.Entry<Integer, Long> _e_ : _o_.channels.entrySet())
/*  681 */         channels.put(_e_.getKey(), _e_.getValue());
/*  682 */       return channels;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChatDataListBean> getChatinfo()
/*      */     {
/*  689 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  690 */       return xdb.Consts.constMap(RoleChatInfo.this.chatinfo);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChatDataListBean> getChatinfoAsData()
/*      */     {
/*  697 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*      */       
/*  699 */       RoleChatInfo _o_ = RoleChatInfo.this;
/*  700 */       Map<Long, xbean.ChatDataListBean> chatinfo = new HashMap();
/*  701 */       for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : _o_.chatinfo.entrySet())
/*  702 */         chatinfo.put(_e_.getKey(), new ChatDataListBean.Data((xbean.ChatDataListBean)_e_.getValue()));
/*  703 */       return chatinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getChatcfg()
/*      */     {
/*  710 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  711 */       return xdb.Consts.constMap(RoleChatInfo.this.chatcfg);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getChatcfgAsData()
/*      */     {
/*  718 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*      */       
/*  720 */       RoleChatInfo _o_ = RoleChatInfo.this;
/*  721 */       Map<Integer, Integer> chatcfg = new HashMap();
/*  722 */       for (Map.Entry<Integer, Integer> _e_ : _o_.chatcfg.entrySet())
/*  723 */         chatcfg.put(_e_.getKey(), _e_.getValue());
/*  724 */       return chatcfg;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChat_room_type()
/*      */     {
/*  731 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  732 */       return RoleChatInfo.this.chat_room_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChat_roomid()
/*      */     {
/*  739 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  740 */       return RoleChatInfo.this.chat_roomid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getSecretchannels()
/*      */     {
/*  747 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  748 */       return xdb.Consts.constMap(RoleChatInfo.this.secretchannels);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getSecretchannelsAsData()
/*      */     {
/*  755 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*      */       
/*  757 */       RoleChatInfo _o_ = RoleChatInfo.this;
/*  758 */       Map<Integer, Long> secretchannels = new HashMap();
/*  759 */       for (Map.Entry<Integer, Long> _e_ : _o_.secretchannels.entrySet())
/*  760 */         secretchannels.put(_e_.getKey(), _e_.getValue());
/*  761 */       return secretchannels;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChat_room_type(int _v_)
/*      */     {
/*  768 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  769 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChat_roomid(int _v_)
/*      */     {
/*  776 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  777 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  783 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  784 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  790 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  791 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  797 */       return RoleChatInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  803 */       return RoleChatInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  809 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  810 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  816 */       return RoleChatInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  822 */       return RoleChatInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  828 */       RoleChatInfo.this._xdb_verify_unsafe_();
/*  829 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  835 */       return RoleChatInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  841 */       return RoleChatInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  847 */       return RoleChatInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  853 */       return RoleChatInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  859 */       return RoleChatInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  865 */       return RoleChatInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  871 */       return RoleChatInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleChatInfo
/*      */   {
/*      */     private HashMap<Integer, Long> channels;
/*      */     
/*      */     private HashMap<Long, xbean.ChatDataListBean> chatinfo;
/*      */     
/*      */     private HashMap<Integer, Integer> chatcfg;
/*      */     
/*      */     private int chat_room_type;
/*      */     
/*      */     private int chat_roomid;
/*      */     
/*      */     private HashMap<Integer, Long> secretchannels;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  893 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  898 */       this.channels = new HashMap();
/*  899 */       this.chatinfo = new HashMap();
/*  900 */       this.chatcfg = new HashMap();
/*  901 */       this.chat_room_type = -1;
/*  902 */       this.chat_roomid = -1;
/*  903 */       this.secretchannels = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.RoleChatInfo _o1_)
/*      */     {
/*  908 */       if ((_o1_ instanceof RoleChatInfo)) { assign((RoleChatInfo)_o1_);
/*  909 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  910 */       } else if ((_o1_ instanceof RoleChatInfo.Const)) assign(((RoleChatInfo.Const)_o1_).nThis()); else {
/*  911 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleChatInfo _o_) {
/*  916 */       this.channels = new HashMap();
/*  917 */       for (Map.Entry<Integer, Long> _e_ : _o_.channels.entrySet())
/*  918 */         this.channels.put(_e_.getKey(), _e_.getValue());
/*  919 */       this.chatinfo = new HashMap();
/*  920 */       for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : _o_.chatinfo.entrySet())
/*  921 */         this.chatinfo.put(_e_.getKey(), new ChatDataListBean.Data((xbean.ChatDataListBean)_e_.getValue()));
/*  922 */       this.chatcfg = new HashMap();
/*  923 */       for (Map.Entry<Integer, Integer> _e_ : _o_.chatcfg.entrySet())
/*  924 */         this.chatcfg.put(_e_.getKey(), _e_.getValue());
/*  925 */       this.chat_room_type = _o_.chat_room_type;
/*  926 */       this.chat_roomid = _o_.chat_roomid;
/*  927 */       this.secretchannels = new HashMap();
/*  928 */       for (Map.Entry<Integer, Long> _e_ : _o_.secretchannels.entrySet()) {
/*  929 */         this.secretchannels.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  934 */       this.channels = new HashMap();
/*  935 */       for (Map.Entry<Integer, Long> _e_ : _o_.channels.entrySet())
/*  936 */         this.channels.put(_e_.getKey(), _e_.getValue());
/*  937 */       this.chatinfo = new HashMap();
/*  938 */       for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : _o_.chatinfo.entrySet())
/*  939 */         this.chatinfo.put(_e_.getKey(), new ChatDataListBean.Data((xbean.ChatDataListBean)_e_.getValue()));
/*  940 */       this.chatcfg = new HashMap();
/*  941 */       for (Map.Entry<Integer, Integer> _e_ : _o_.chatcfg.entrySet())
/*  942 */         this.chatcfg.put(_e_.getKey(), _e_.getValue());
/*  943 */       this.chat_room_type = _o_.chat_room_type;
/*  944 */       this.chat_roomid = _o_.chat_roomid;
/*  945 */       this.secretchannels = new HashMap();
/*  946 */       for (Map.Entry<Integer, Long> _e_ : _o_.secretchannels.entrySet()) {
/*  947 */         this.secretchannels.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  953 */       _os_.compact_uint32(this.channels.size());
/*  954 */       for (Map.Entry<Integer, Long> _e_ : this.channels.entrySet())
/*      */       {
/*  956 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  957 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/*  959 */       _os_.compact_uint32(this.chatinfo.size());
/*  960 */       for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : this.chatinfo.entrySet())
/*      */       {
/*  962 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  963 */         ((xbean.ChatDataListBean)_e_.getValue()).marshal(_os_);
/*      */       }
/*  965 */       _os_.compact_uint32(this.chatcfg.size());
/*  966 */       for (Map.Entry<Integer, Integer> _e_ : this.chatcfg.entrySet())
/*      */       {
/*  968 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  969 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  971 */       _os_.marshal(this.chat_room_type);
/*  972 */       _os_.marshal(this.chat_roomid);
/*  973 */       _os_.compact_uint32(this.secretchannels.size());
/*  974 */       for (Map.Entry<Integer, Long> _e_ : this.secretchannels.entrySet())
/*      */       {
/*  976 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  977 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/*  979 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  986 */       int size = _os_.uncompact_uint32();
/*  987 */       if (size >= 12)
/*      */       {
/*  989 */         this.channels = new HashMap(size * 2);
/*      */       }
/*  991 */       for (; size > 0; size--)
/*      */       {
/*  993 */         int _k_ = 0;
/*  994 */         _k_ = _os_.unmarshal_int();
/*  995 */         long _v_ = 0L;
/*  996 */         _v_ = _os_.unmarshal_long();
/*  997 */         this.channels.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 1001 */       int size = _os_.uncompact_uint32();
/* 1002 */       if (size >= 12)
/*      */       {
/* 1004 */         this.chatinfo = new HashMap(size * 2);
/*      */       }
/* 1006 */       for (; size > 0; size--)
/*      */       {
/* 1008 */         long _k_ = 0L;
/* 1009 */         _k_ = _os_.unmarshal_long();
/* 1010 */         xbean.ChatDataListBean _v_ = xbean.Pod.newChatDataListBeanData();
/* 1011 */         _v_.unmarshal(_os_);
/* 1012 */         this.chatinfo.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1016 */       int size = _os_.uncompact_uint32();
/* 1017 */       if (size >= 12)
/*      */       {
/* 1019 */         this.chatcfg = new HashMap(size * 2);
/*      */       }
/* 1021 */       for (; size > 0; size--)
/*      */       {
/* 1023 */         int _k_ = 0;
/* 1024 */         _k_ = _os_.unmarshal_int();
/* 1025 */         int _v_ = 0;
/* 1026 */         _v_ = _os_.unmarshal_int();
/* 1027 */         this.chatcfg.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1030 */       this.chat_room_type = _os_.unmarshal_int();
/* 1031 */       this.chat_roomid = _os_.unmarshal_int();
/*      */       
/* 1033 */       int size = _os_.uncompact_uint32();
/* 1034 */       if (size >= 12)
/*      */       {
/* 1036 */         this.secretchannels = new HashMap(size * 2);
/*      */       }
/* 1038 */       for (; size > 0; size--)
/*      */       {
/* 1040 */         int _k_ = 0;
/* 1041 */         _k_ = _os_.unmarshal_int();
/* 1042 */         long _v_ = 0L;
/* 1043 */         _v_ = _os_.unmarshal_long();
/* 1044 */         this.secretchannels.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/* 1047 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1053 */       int _size_ = 0;
/* 1054 */       for (Map.Entry<Integer, Long> _e_ : this.channels.entrySet())
/*      */       {
/* 1056 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 1057 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getValue()).longValue());
/*      */       }
/* 1059 */       for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : this.chatinfo.entrySet())
/*      */       {
/* 1061 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 1062 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1064 */       for (Map.Entry<Integer, Integer> _e_ : this.chatcfg.entrySet())
/*      */       {
/* 1066 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 1067 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1069 */       _size_ += CodedOutputStream.computeInt32Size(4, this.chat_room_type);
/* 1070 */       _size_ += CodedOutputStream.computeInt32Size(5, this.chat_roomid);
/* 1071 */       for (Map.Entry<Integer, Long> _e_ : this.secretchannels.entrySet())
/*      */       {
/* 1073 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 1074 */         _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getValue()).longValue());
/*      */       }
/* 1076 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1084 */         for (Map.Entry<Integer, Long> _e_ : this.channels.entrySet())
/*      */         {
/* 1086 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 1087 */           _output_.writeInt64(1, ((Long)_e_.getValue()).longValue());
/*      */         }
/* 1089 */         for (Map.Entry<Long, xbean.ChatDataListBean> _e_ : this.chatinfo.entrySet())
/*      */         {
/* 1091 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 1092 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1094 */         for (Map.Entry<Integer, Integer> _e_ : this.chatcfg.entrySet())
/*      */         {
/* 1096 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 1097 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1099 */         _output_.writeInt32(4, this.chat_room_type);
/* 1100 */         _output_.writeInt32(5, this.chat_roomid);
/* 1101 */         for (Map.Entry<Integer, Long> _e_ : this.secretchannels.entrySet())
/*      */         {
/* 1103 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 1104 */           _output_.writeInt64(6, ((Long)_e_.getValue()).longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1109 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1111 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1119 */         boolean done = false;
/* 1120 */         while (!done)
/*      */         {
/* 1122 */           int tag = _input_.readTag();
/* 1123 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1127 */             done = true;
/* 1128 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1132 */             int _k_ = 0;
/* 1133 */             _k_ = _input_.readInt32();
/* 1134 */             int readTag = _input_.readTag();
/* 1135 */             if (8 != readTag)
/*      */             {
/* 1137 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1139 */             long _v_ = 0L;
/* 1140 */             _v_ = _input_.readInt64();
/* 1141 */             this.channels.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 1142 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1146 */             long _k_ = 0L;
/* 1147 */             _k_ = _input_.readInt64();
/* 1148 */             int readTag = _input_.readTag();
/* 1149 */             if (18 != readTag)
/*      */             {
/* 1151 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1153 */             xbean.ChatDataListBean _v_ = xbean.Pod.newChatDataListBeanData();
/* 1154 */             _input_.readMessage(_v_);
/* 1155 */             this.chatinfo.put(Long.valueOf(_k_), _v_);
/* 1156 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1160 */             int _k_ = 0;
/* 1161 */             _k_ = _input_.readInt32();
/* 1162 */             int readTag = _input_.readTag();
/* 1163 */             if (24 != readTag)
/*      */             {
/* 1165 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1167 */             int _v_ = 0;
/* 1168 */             _v_ = _input_.readInt32();
/* 1169 */             this.chatcfg.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1170 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1174 */             this.chat_room_type = _input_.readInt32();
/* 1175 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1179 */             this.chat_roomid = _input_.readInt32();
/* 1180 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1184 */             int _k_ = 0;
/* 1185 */             _k_ = _input_.readInt32();
/* 1186 */             int readTag = _input_.readTag();
/* 1187 */             if (48 != readTag)
/*      */             {
/* 1189 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1191 */             long _v_ = 0L;
/* 1192 */             _v_ = _input_.readInt64();
/* 1193 */             this.secretchannels.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 1194 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1198 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1200 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1209 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1213 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1215 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleChatInfo copy()
/*      */     {
/* 1221 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleChatInfo toData()
/*      */     {
/* 1227 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleChatInfo toBean()
/*      */     {
/* 1232 */       return new RoleChatInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleChatInfo toDataIf()
/*      */     {
/* 1238 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleChatInfo toBeanIf()
/*      */     {
/* 1243 */       return new RoleChatInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1249 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1253 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1257 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1261 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1265 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1269 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1273 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getChannels()
/*      */     {
/* 1280 */       return this.channels;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getChannelsAsData()
/*      */     {
/* 1287 */       return this.channels;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChatDataListBean> getChatinfo()
/*      */     {
/* 1294 */       return this.chatinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChatDataListBean> getChatinfoAsData()
/*      */     {
/* 1301 */       return this.chatinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getChatcfg()
/*      */     {
/* 1308 */       return this.chatcfg;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getChatcfgAsData()
/*      */     {
/* 1315 */       return this.chatcfg;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChat_room_type()
/*      */     {
/* 1322 */       return this.chat_room_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChat_roomid()
/*      */     {
/* 1329 */       return this.chat_roomid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getSecretchannels()
/*      */     {
/* 1336 */       return this.secretchannels;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getSecretchannelsAsData()
/*      */     {
/* 1343 */       return this.secretchannels;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChat_room_type(int _v_)
/*      */     {
/* 1350 */       this.chat_room_type = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChat_roomid(int _v_)
/*      */     {
/* 1357 */       this.chat_roomid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1363 */       if (!(_o1_ instanceof Data)) return false;
/* 1364 */       Data _o_ = (Data)_o1_;
/* 1365 */       if (!this.channels.equals(_o_.channels)) return false;
/* 1366 */       if (!this.chatinfo.equals(_o_.chatinfo)) return false;
/* 1367 */       if (!this.chatcfg.equals(_o_.chatcfg)) return false;
/* 1368 */       if (this.chat_room_type != _o_.chat_room_type) return false;
/* 1369 */       if (this.chat_roomid != _o_.chat_roomid) return false;
/* 1370 */       if (!this.secretchannels.equals(_o_.secretchannels)) return false;
/* 1371 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1377 */       int _h_ = 0;
/* 1378 */       _h_ += this.channels.hashCode();
/* 1379 */       _h_ += this.chatinfo.hashCode();
/* 1380 */       _h_ += this.chatcfg.hashCode();
/* 1381 */       _h_ += this.chat_room_type;
/* 1382 */       _h_ += this.chat_roomid;
/* 1383 */       _h_ += this.secretchannels.hashCode();
/* 1384 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1390 */       StringBuilder _sb_ = new StringBuilder();
/* 1391 */       _sb_.append("(");
/* 1392 */       _sb_.append(this.channels);
/* 1393 */       _sb_.append(",");
/* 1394 */       _sb_.append(this.chatinfo);
/* 1395 */       _sb_.append(",");
/* 1396 */       _sb_.append(this.chatcfg);
/* 1397 */       _sb_.append(",");
/* 1398 */       _sb_.append(this.chat_room_type);
/* 1399 */       _sb_.append(",");
/* 1400 */       _sb_.append(this.chat_roomid);
/* 1401 */       _sb_.append(",");
/* 1402 */       _sb_.append(this.secretchannels);
/* 1403 */       _sb_.append(")");
/* 1404 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleChatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */