/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xbean.Pod;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ import xdb.logs.ListenableSet;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ 
/*      */ public final class Role2FriendsCircleInfo
/*      */   extends XBean
/*      */   implements xbean.Role2FriendsCircleInfo
/*      */ {
/*      */   private int treasure_box_num;
/*      */   private int today_get_treasure_box_num;
/*      */   private long last_get_treasure_box_time;
/*      */   private long last_week_popularity_value_refresh_time;
/*      */   private int current_week_popularity_value;
/*      */   private int total_popularity_value;
/*      */   private int receive_gift_num;
/*      */   private HashMap<Long, Integer> today_tread_circle_role_id_map;
/*      */   private long last_tread_circle_time;
/*      */   private HashMap<Long, Integer> today_tread_my_circle_role_id_map;
/*      */   private long last_tread_my_circle_time;
/*      */   private HashMap<Integer, Long> own_pendant_ornament_map;
/*      */   private HashMap<Integer, Long> own_rahmen_ornament_map;
/*      */   private xbean.FriendsCircleOrnamentItem current_pendant_ornament;
/*      */   private xbean.FriendsCircleOrnamentItem current_rahmen_ornament;
/*      */   private HashMap<Long, xbean.CrossServerFriendsCircleGift> cross_server_send_gift;
/*      */   private HashMap<Long, xbean.CrossServerFriendsCircleTread> cross_server_tread;
/*      */   private HashMap<Long, xbean.FriendsCircleGiftResult> be_sent_gift;
/*      */   private HashMap<Long, xbean.FriendsCircleTreadResult> be_trod_result;
/*      */   private HashMap<Long, xbean.FriendsCirclePlaceTreasureResult> place_treasure_result;
/*      */   private boolean update_ornament_result;
/*      */   private int today_get_popularity_from_tread;
/*      */   private ArrayList<Long> my_black_role_list;
/*      */   private SetX<Long> cross_server_black_in_role_set;
/*      */   private HashMap<Long, xbean.CrossServerFriendsCircleBlackRole> cross_server_black_operator;
/*      */   private int repair_tread;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   68 */     this.treasure_box_num = 0;
/*   69 */     this.today_get_treasure_box_num = 0;
/*   70 */     this.last_get_treasure_box_time = 0L;
/*   71 */     this.last_week_popularity_value_refresh_time = 0L;
/*   72 */     this.current_week_popularity_value = 0;
/*   73 */     this.total_popularity_value = 0;
/*   74 */     this.receive_gift_num = 0;
/*   75 */     this.today_tread_circle_role_id_map.clear();
/*   76 */     this.last_tread_circle_time = 0L;
/*   77 */     this.today_tread_my_circle_role_id_map.clear();
/*   78 */     this.last_tread_my_circle_time = 0L;
/*   79 */     this.own_pendant_ornament_map.clear();
/*   80 */     this.own_rahmen_ornament_map.clear();
/*   81 */     this.current_pendant_ornament._reset_unsafe_();
/*   82 */     this.current_rahmen_ornament._reset_unsafe_();
/*   83 */     this.cross_server_send_gift.clear();
/*   84 */     this.cross_server_tread.clear();
/*   85 */     this.be_sent_gift.clear();
/*   86 */     this.be_trod_result.clear();
/*   87 */     this.place_treasure_result.clear();
/*   88 */     this.update_ornament_result = true;
/*   89 */     this.today_get_popularity_from_tread = 0;
/*   90 */     this.my_black_role_list.clear();
/*   91 */     this.cross_server_black_in_role_set.clear();
/*   92 */     this.cross_server_black_operator.clear();
/*   93 */     this.repair_tread = 0;
/*      */   }
/*      */   
/*      */   Role2FriendsCircleInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   98 */     super(_xp_, _vn_);
/*   99 */     this.today_tread_circle_role_id_map = new HashMap();
/*  100 */     this.today_tread_my_circle_role_id_map = new HashMap();
/*  101 */     this.own_pendant_ornament_map = new HashMap();
/*  102 */     this.own_rahmen_ornament_map = new HashMap();
/*  103 */     this.current_pendant_ornament = new FriendsCircleOrnamentItem(0, this, "current_pendant_ornament");
/*  104 */     this.current_rahmen_ornament = new FriendsCircleOrnamentItem(0, this, "current_rahmen_ornament");
/*  105 */     this.cross_server_send_gift = new HashMap();
/*  106 */     this.cross_server_tread = new HashMap();
/*  107 */     this.be_sent_gift = new HashMap();
/*  108 */     this.be_trod_result = new HashMap();
/*  109 */     this.place_treasure_result = new HashMap();
/*  110 */     this.update_ornament_result = true;
/*  111 */     this.my_black_role_list = new ArrayList();
/*  112 */     this.cross_server_black_in_role_set = new SetX();
/*  113 */     this.cross_server_black_operator = new HashMap();
/*      */   }
/*      */   
/*      */   public Role2FriendsCircleInfo()
/*      */   {
/*  118 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Role2FriendsCircleInfo(Role2FriendsCircleInfo _o_)
/*      */   {
/*  123 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Role2FriendsCircleInfo(xbean.Role2FriendsCircleInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  128 */     super(_xp_, _vn_);
/*  129 */     if ((_o1_ instanceof Role2FriendsCircleInfo)) { assign((Role2FriendsCircleInfo)_o1_);
/*  130 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  131 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  132 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Role2FriendsCircleInfo _o_) {
/*  137 */     _o_._xdb_verify_unsafe_();
/*  138 */     this.treasure_box_num = _o_.treasure_box_num;
/*  139 */     this.today_get_treasure_box_num = _o_.today_get_treasure_box_num;
/*  140 */     this.last_get_treasure_box_time = _o_.last_get_treasure_box_time;
/*  141 */     this.last_week_popularity_value_refresh_time = _o_.last_week_popularity_value_refresh_time;
/*  142 */     this.current_week_popularity_value = _o_.current_week_popularity_value;
/*  143 */     this.total_popularity_value = _o_.total_popularity_value;
/*  144 */     this.receive_gift_num = _o_.receive_gift_num;
/*  145 */     this.today_tread_circle_role_id_map = new HashMap();
/*  146 */     for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_circle_role_id_map.entrySet())
/*  147 */       this.today_tread_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/*  148 */     this.last_tread_circle_time = _o_.last_tread_circle_time;
/*  149 */     this.today_tread_my_circle_role_id_map = new HashMap();
/*  150 */     for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_my_circle_role_id_map.entrySet())
/*  151 */       this.today_tread_my_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/*  152 */     this.last_tread_my_circle_time = _o_.last_tread_my_circle_time;
/*  153 */     this.own_pendant_ornament_map = new HashMap();
/*  154 */     for (Map.Entry<Integer, Long> _e_ : _o_.own_pendant_ornament_map.entrySet())
/*  155 */       this.own_pendant_ornament_map.put(_e_.getKey(), _e_.getValue());
/*  156 */     this.own_rahmen_ornament_map = new HashMap();
/*  157 */     for (Map.Entry<Integer, Long> _e_ : _o_.own_rahmen_ornament_map.entrySet())
/*  158 */       this.own_rahmen_ornament_map.put(_e_.getKey(), _e_.getValue());
/*  159 */     this.current_pendant_ornament = new FriendsCircleOrnamentItem(_o_.current_pendant_ornament, this, "current_pendant_ornament");
/*  160 */     this.current_rahmen_ornament = new FriendsCircleOrnamentItem(_o_.current_rahmen_ornament, this, "current_rahmen_ornament");
/*  161 */     this.cross_server_send_gift = new HashMap();
/*  162 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : _o_.cross_server_send_gift.entrySet())
/*  163 */       this.cross_server_send_gift.put(_e_.getKey(), new CrossServerFriendsCircleGift((xbean.CrossServerFriendsCircleGift)_e_.getValue(), this, "cross_server_send_gift"));
/*  164 */     this.cross_server_tread = new HashMap();
/*  165 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : _o_.cross_server_tread.entrySet())
/*  166 */       this.cross_server_tread.put(_e_.getKey(), new CrossServerFriendsCircleTread((xbean.CrossServerFriendsCircleTread)_e_.getValue(), this, "cross_server_tread"));
/*  167 */     this.be_sent_gift = new HashMap();
/*  168 */     for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : _o_.be_sent_gift.entrySet())
/*  169 */       this.be_sent_gift.put(_e_.getKey(), new FriendsCircleGiftResult((xbean.FriendsCircleGiftResult)_e_.getValue(), this, "be_sent_gift"));
/*  170 */     this.be_trod_result = new HashMap();
/*  171 */     for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : _o_.be_trod_result.entrySet())
/*  172 */       this.be_trod_result.put(_e_.getKey(), new FriendsCircleTreadResult((xbean.FriendsCircleTreadResult)_e_.getValue(), this, "be_trod_result"));
/*  173 */     this.place_treasure_result = new HashMap();
/*  174 */     for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : _o_.place_treasure_result.entrySet())
/*  175 */       this.place_treasure_result.put(_e_.getKey(), new FriendsCirclePlaceTreasureResult((xbean.FriendsCirclePlaceTreasureResult)_e_.getValue(), this, "place_treasure_result"));
/*  176 */     this.update_ornament_result = _o_.update_ornament_result;
/*  177 */     this.today_get_popularity_from_tread = _o_.today_get_popularity_from_tread;
/*  178 */     this.my_black_role_list = new ArrayList();
/*  179 */     this.my_black_role_list.addAll(_o_.my_black_role_list);
/*  180 */     this.cross_server_black_in_role_set = new SetX();
/*  181 */     this.cross_server_black_in_role_set.addAll(_o_.cross_server_black_in_role_set);
/*  182 */     this.cross_server_black_operator = new HashMap();
/*  183 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : _o_.cross_server_black_operator.entrySet())
/*  184 */       this.cross_server_black_operator.put(_e_.getKey(), new CrossServerFriendsCircleBlackRole((xbean.CrossServerFriendsCircleBlackRole)_e_.getValue(), this, "cross_server_black_operator"));
/*  185 */     this.repair_tread = _o_.repair_tread;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  190 */     this.treasure_box_num = _o_.treasure_box_num;
/*  191 */     this.today_get_treasure_box_num = _o_.today_get_treasure_box_num;
/*  192 */     this.last_get_treasure_box_time = _o_.last_get_treasure_box_time;
/*  193 */     this.last_week_popularity_value_refresh_time = _o_.last_week_popularity_value_refresh_time;
/*  194 */     this.current_week_popularity_value = _o_.current_week_popularity_value;
/*  195 */     this.total_popularity_value = _o_.total_popularity_value;
/*  196 */     this.receive_gift_num = _o_.receive_gift_num;
/*  197 */     this.today_tread_circle_role_id_map = new HashMap();
/*  198 */     for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_circle_role_id_map.entrySet())
/*  199 */       this.today_tread_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/*  200 */     this.last_tread_circle_time = _o_.last_tread_circle_time;
/*  201 */     this.today_tread_my_circle_role_id_map = new HashMap();
/*  202 */     for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_my_circle_role_id_map.entrySet())
/*  203 */       this.today_tread_my_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/*  204 */     this.last_tread_my_circle_time = _o_.last_tread_my_circle_time;
/*  205 */     this.own_pendant_ornament_map = new HashMap();
/*  206 */     for (Map.Entry<Integer, Long> _e_ : _o_.own_pendant_ornament_map.entrySet())
/*  207 */       this.own_pendant_ornament_map.put(_e_.getKey(), _e_.getValue());
/*  208 */     this.own_rahmen_ornament_map = new HashMap();
/*  209 */     for (Map.Entry<Integer, Long> _e_ : _o_.own_rahmen_ornament_map.entrySet())
/*  210 */       this.own_rahmen_ornament_map.put(_e_.getKey(), _e_.getValue());
/*  211 */     this.current_pendant_ornament = new FriendsCircleOrnamentItem(_o_.current_pendant_ornament, this, "current_pendant_ornament");
/*  212 */     this.current_rahmen_ornament = new FriendsCircleOrnamentItem(_o_.current_rahmen_ornament, this, "current_rahmen_ornament");
/*  213 */     this.cross_server_send_gift = new HashMap();
/*  214 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : _o_.cross_server_send_gift.entrySet())
/*  215 */       this.cross_server_send_gift.put(_e_.getKey(), new CrossServerFriendsCircleGift((xbean.CrossServerFriendsCircleGift)_e_.getValue(), this, "cross_server_send_gift"));
/*  216 */     this.cross_server_tread = new HashMap();
/*  217 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : _o_.cross_server_tread.entrySet())
/*  218 */       this.cross_server_tread.put(_e_.getKey(), new CrossServerFriendsCircleTread((xbean.CrossServerFriendsCircleTread)_e_.getValue(), this, "cross_server_tread"));
/*  219 */     this.be_sent_gift = new HashMap();
/*  220 */     for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : _o_.be_sent_gift.entrySet())
/*  221 */       this.be_sent_gift.put(_e_.getKey(), new FriendsCircleGiftResult((xbean.FriendsCircleGiftResult)_e_.getValue(), this, "be_sent_gift"));
/*  222 */     this.be_trod_result = new HashMap();
/*  223 */     for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : _o_.be_trod_result.entrySet())
/*  224 */       this.be_trod_result.put(_e_.getKey(), new FriendsCircleTreadResult((xbean.FriendsCircleTreadResult)_e_.getValue(), this, "be_trod_result"));
/*  225 */     this.place_treasure_result = new HashMap();
/*  226 */     for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : _o_.place_treasure_result.entrySet())
/*  227 */       this.place_treasure_result.put(_e_.getKey(), new FriendsCirclePlaceTreasureResult((xbean.FriendsCirclePlaceTreasureResult)_e_.getValue(), this, "place_treasure_result"));
/*  228 */     this.update_ornament_result = _o_.update_ornament_result;
/*  229 */     this.today_get_popularity_from_tread = _o_.today_get_popularity_from_tread;
/*  230 */     this.my_black_role_list = new ArrayList();
/*  231 */     this.my_black_role_list.addAll(_o_.my_black_role_list);
/*  232 */     this.cross_server_black_in_role_set = new SetX();
/*  233 */     this.cross_server_black_in_role_set.addAll(_o_.cross_server_black_in_role_set);
/*  234 */     this.cross_server_black_operator = new HashMap();
/*  235 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : _o_.cross_server_black_operator.entrySet())
/*  236 */       this.cross_server_black_operator.put(_e_.getKey(), new CrossServerFriendsCircleBlackRole((xbean.CrossServerFriendsCircleBlackRole)_e_.getValue(), this, "cross_server_black_operator"));
/*  237 */     this.repair_tread = _o_.repair_tread;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  243 */     _xdb_verify_unsafe_();
/*  244 */     _os_.marshal(this.treasure_box_num);
/*  245 */     _os_.marshal(this.today_get_treasure_box_num);
/*  246 */     _os_.marshal(this.last_get_treasure_box_time);
/*  247 */     _os_.marshal(this.last_week_popularity_value_refresh_time);
/*  248 */     _os_.marshal(this.current_week_popularity_value);
/*  249 */     _os_.marshal(this.total_popularity_value);
/*  250 */     _os_.marshal(this.receive_gift_num);
/*  251 */     _os_.compact_uint32(this.today_tread_circle_role_id_map.size());
/*  252 */     for (Map.Entry<Long, Integer> _e_ : this.today_tread_circle_role_id_map.entrySet())
/*      */     {
/*  254 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  255 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  257 */     _os_.marshal(this.last_tread_circle_time);
/*  258 */     _os_.compact_uint32(this.today_tread_my_circle_role_id_map.size());
/*  259 */     for (Map.Entry<Long, Integer> _e_ : this.today_tread_my_circle_role_id_map.entrySet())
/*      */     {
/*  261 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  262 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  264 */     _os_.marshal(this.last_tread_my_circle_time);
/*  265 */     _os_.compact_uint32(this.own_pendant_ornament_map.size());
/*  266 */     for (Map.Entry<Integer, Long> _e_ : this.own_pendant_ornament_map.entrySet())
/*      */     {
/*  268 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  269 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  271 */     _os_.compact_uint32(this.own_rahmen_ornament_map.size());
/*  272 */     for (Map.Entry<Integer, Long> _e_ : this.own_rahmen_ornament_map.entrySet())
/*      */     {
/*  274 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  275 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  277 */     this.current_pendant_ornament.marshal(_os_);
/*  278 */     this.current_rahmen_ornament.marshal(_os_);
/*  279 */     _os_.compact_uint32(this.cross_server_send_gift.size());
/*  280 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : this.cross_server_send_gift.entrySet())
/*      */     {
/*  282 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  283 */       ((xbean.CrossServerFriendsCircleGift)_e_.getValue()).marshal(_os_);
/*      */     }
/*  285 */     _os_.compact_uint32(this.cross_server_tread.size());
/*  286 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : this.cross_server_tread.entrySet())
/*      */     {
/*  288 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  289 */       ((xbean.CrossServerFriendsCircleTread)_e_.getValue()).marshal(_os_);
/*      */     }
/*  291 */     _os_.compact_uint32(this.be_sent_gift.size());
/*  292 */     for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : this.be_sent_gift.entrySet())
/*      */     {
/*  294 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  295 */       ((xbean.FriendsCircleGiftResult)_e_.getValue()).marshal(_os_);
/*      */     }
/*  297 */     _os_.compact_uint32(this.be_trod_result.size());
/*  298 */     for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : this.be_trod_result.entrySet())
/*      */     {
/*  300 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  301 */       ((xbean.FriendsCircleTreadResult)_e_.getValue()).marshal(_os_);
/*      */     }
/*  303 */     _os_.compact_uint32(this.place_treasure_result.size());
/*  304 */     for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : this.place_treasure_result.entrySet())
/*      */     {
/*  306 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  307 */       ((xbean.FriendsCirclePlaceTreasureResult)_e_.getValue()).marshal(_os_);
/*      */     }
/*  309 */     _os_.marshal(this.update_ornament_result);
/*  310 */     _os_.marshal(this.today_get_popularity_from_tread);
/*  311 */     _os_.compact_uint32(this.my_black_role_list.size());
/*  312 */     for (Long _v_ : this.my_black_role_list)
/*      */     {
/*  314 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  316 */     _os_.compact_uint32(this.cross_server_black_in_role_set.size());
/*  317 */     for (Long _v_ : this.cross_server_black_in_role_set)
/*      */     {
/*  319 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  321 */     _os_.compact_uint32(this.cross_server_black_operator.size());
/*  322 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : this.cross_server_black_operator.entrySet())
/*      */     {
/*  324 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  325 */       ((xbean.CrossServerFriendsCircleBlackRole)_e_.getValue()).marshal(_os_);
/*      */     }
/*  327 */     _os_.marshal(this.repair_tread);
/*  328 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     this.treasure_box_num = _os_.unmarshal_int();
/*  336 */     this.today_get_treasure_box_num = _os_.unmarshal_int();
/*  337 */     this.last_get_treasure_box_time = _os_.unmarshal_long();
/*  338 */     this.last_week_popularity_value_refresh_time = _os_.unmarshal_long();
/*  339 */     this.current_week_popularity_value = _os_.unmarshal_int();
/*  340 */     this.total_popularity_value = _os_.unmarshal_int();
/*  341 */     this.receive_gift_num = _os_.unmarshal_int();
/*      */     
/*  343 */     int size = _os_.uncompact_uint32();
/*  344 */     if (size >= 12)
/*      */     {
/*  346 */       this.today_tread_circle_role_id_map = new HashMap(size * 2);
/*      */     }
/*  348 */     for (; size > 0; size--)
/*      */     {
/*  350 */       long _k_ = 0L;
/*  351 */       _k_ = _os_.unmarshal_long();
/*  352 */       int _v_ = 0;
/*  353 */       _v_ = _os_.unmarshal_int();
/*  354 */       this.today_tread_circle_role_id_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  357 */     this.last_tread_circle_time = _os_.unmarshal_long();
/*      */     
/*  359 */     int size = _os_.uncompact_uint32();
/*  360 */     if (size >= 12)
/*      */     {
/*  362 */       this.today_tread_my_circle_role_id_map = new HashMap(size * 2);
/*      */     }
/*  364 */     for (; size > 0; size--)
/*      */     {
/*  366 */       long _k_ = 0L;
/*  367 */       _k_ = _os_.unmarshal_long();
/*  368 */       int _v_ = 0;
/*  369 */       _v_ = _os_.unmarshal_int();
/*  370 */       this.today_tread_my_circle_role_id_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  373 */     this.last_tread_my_circle_time = _os_.unmarshal_long();
/*      */     
/*  375 */     int size = _os_.uncompact_uint32();
/*  376 */     if (size >= 12)
/*      */     {
/*  378 */       this.own_pendant_ornament_map = new HashMap(size * 2);
/*      */     }
/*  380 */     for (; size > 0; size--)
/*      */     {
/*  382 */       int _k_ = 0;
/*  383 */       _k_ = _os_.unmarshal_int();
/*  384 */       long _v_ = 0L;
/*  385 */       _v_ = _os_.unmarshal_long();
/*  386 */       this.own_pendant_ornament_map.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  390 */     int size = _os_.uncompact_uint32();
/*  391 */     if (size >= 12)
/*      */     {
/*  393 */       this.own_rahmen_ornament_map = new HashMap(size * 2);
/*      */     }
/*  395 */     for (; size > 0; size--)
/*      */     {
/*  397 */       int _k_ = 0;
/*  398 */       _k_ = _os_.unmarshal_int();
/*  399 */       long _v_ = 0L;
/*  400 */       _v_ = _os_.unmarshal_long();
/*  401 */       this.own_rahmen_ornament_map.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*  404 */     this.current_pendant_ornament.unmarshal(_os_);
/*  405 */     this.current_rahmen_ornament.unmarshal(_os_);
/*      */     
/*  407 */     int size = _os_.uncompact_uint32();
/*  408 */     if (size >= 12)
/*      */     {
/*  410 */       this.cross_server_send_gift = new HashMap(size * 2);
/*      */     }
/*  412 */     for (; size > 0; size--)
/*      */     {
/*  414 */       long _k_ = 0L;
/*  415 */       _k_ = _os_.unmarshal_long();
/*  416 */       xbean.CrossServerFriendsCircleGift _v_ = new CrossServerFriendsCircleGift(0, this, "cross_server_send_gift");
/*  417 */       _v_.unmarshal(_os_);
/*  418 */       this.cross_server_send_gift.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  422 */     int size = _os_.uncompact_uint32();
/*  423 */     if (size >= 12)
/*      */     {
/*  425 */       this.cross_server_tread = new HashMap(size * 2);
/*      */     }
/*  427 */     for (; size > 0; size--)
/*      */     {
/*  429 */       long _k_ = 0L;
/*  430 */       _k_ = _os_.unmarshal_long();
/*  431 */       xbean.CrossServerFriendsCircleTread _v_ = new CrossServerFriendsCircleTread(0, this, "cross_server_tread");
/*  432 */       _v_.unmarshal(_os_);
/*  433 */       this.cross_server_tread.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  437 */     int size = _os_.uncompact_uint32();
/*  438 */     if (size >= 12)
/*      */     {
/*  440 */       this.be_sent_gift = new HashMap(size * 2);
/*      */     }
/*  442 */     for (; size > 0; size--)
/*      */     {
/*  444 */       long _k_ = 0L;
/*  445 */       _k_ = _os_.unmarshal_long();
/*  446 */       xbean.FriendsCircleGiftResult _v_ = new FriendsCircleGiftResult(0, this, "be_sent_gift");
/*  447 */       _v_.unmarshal(_os_);
/*  448 */       this.be_sent_gift.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  452 */     int size = _os_.uncompact_uint32();
/*  453 */     if (size >= 12)
/*      */     {
/*  455 */       this.be_trod_result = new HashMap(size * 2);
/*      */     }
/*  457 */     for (; size > 0; size--)
/*      */     {
/*  459 */       long _k_ = 0L;
/*  460 */       _k_ = _os_.unmarshal_long();
/*  461 */       xbean.FriendsCircleTreadResult _v_ = new FriendsCircleTreadResult(0, this, "be_trod_result");
/*  462 */       _v_.unmarshal(_os_);
/*  463 */       this.be_trod_result.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  467 */     int size = _os_.uncompact_uint32();
/*  468 */     if (size >= 12)
/*      */     {
/*  470 */       this.place_treasure_result = new HashMap(size * 2);
/*      */     }
/*  472 */     for (; size > 0; size--)
/*      */     {
/*  474 */       long _k_ = 0L;
/*  475 */       _k_ = _os_.unmarshal_long();
/*  476 */       xbean.FriendsCirclePlaceTreasureResult _v_ = new FriendsCirclePlaceTreasureResult(0, this, "place_treasure_result");
/*  477 */       _v_.unmarshal(_os_);
/*  478 */       this.place_treasure_result.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  481 */     this.update_ornament_result = _os_.unmarshal_boolean();
/*  482 */     this.today_get_popularity_from_tread = _os_.unmarshal_int();
/*  483 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  485 */       long _v_ = 0L;
/*  486 */       _v_ = _os_.unmarshal_long();
/*  487 */       this.my_black_role_list.add(Long.valueOf(_v_));
/*      */     }
/*  489 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  491 */       long _v_ = 0L;
/*  492 */       _v_ = _os_.unmarshal_long();
/*  493 */       this.cross_server_black_in_role_set.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  496 */     int size = _os_.uncompact_uint32();
/*  497 */     if (size >= 12)
/*      */     {
/*  499 */       this.cross_server_black_operator = new HashMap(size * 2);
/*      */     }
/*  501 */     for (; size > 0; size--)
/*      */     {
/*  503 */       long _k_ = 0L;
/*  504 */       _k_ = _os_.unmarshal_long();
/*  505 */       xbean.CrossServerFriendsCircleBlackRole _v_ = new CrossServerFriendsCircleBlackRole(0, this, "cross_server_black_operator");
/*  506 */       _v_.unmarshal(_os_);
/*  507 */       this.cross_server_black_operator.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  510 */     this.repair_tread = _os_.unmarshal_int();
/*  511 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  517 */     _xdb_verify_unsafe_();
/*  518 */     int _size_ = 0;
/*  519 */     _size_ += CodedOutputStream.computeInt32Size(1, this.treasure_box_num);
/*  520 */     _size_ += CodedOutputStream.computeInt32Size(2, this.today_get_treasure_box_num);
/*  521 */     _size_ += CodedOutputStream.computeInt64Size(3, this.last_get_treasure_box_time);
/*  522 */     _size_ += CodedOutputStream.computeInt64Size(4, this.last_week_popularity_value_refresh_time);
/*  523 */     _size_ += CodedOutputStream.computeInt32Size(5, this.current_week_popularity_value);
/*  524 */     _size_ += CodedOutputStream.computeInt32Size(6, this.total_popularity_value);
/*  525 */     _size_ += CodedOutputStream.computeInt32Size(7, this.receive_gift_num);
/*  526 */     for (Map.Entry<Long, Integer> _e_ : this.today_tread_circle_role_id_map.entrySet())
/*      */     {
/*  528 */       _size_ += CodedOutputStream.computeInt64Size(8, ((Long)_e_.getKey()).longValue());
/*  529 */       _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  531 */     _size_ += CodedOutputStream.computeInt64Size(9, this.last_tread_circle_time);
/*  532 */     for (Map.Entry<Long, Integer> _e_ : this.today_tread_my_circle_role_id_map.entrySet())
/*      */     {
/*  534 */       _size_ += CodedOutputStream.computeInt64Size(10, ((Long)_e_.getKey()).longValue());
/*  535 */       _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  537 */     _size_ += CodedOutputStream.computeInt64Size(11, this.last_tread_my_circle_time);
/*  538 */     for (Map.Entry<Integer, Long> _e_ : this.own_pendant_ornament_map.entrySet())
/*      */     {
/*  540 */       _size_ += CodedOutputStream.computeInt32Size(15, ((Integer)_e_.getKey()).intValue());
/*  541 */       _size_ += CodedOutputStream.computeInt64Size(15, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  543 */     for (Map.Entry<Integer, Long> _e_ : this.own_rahmen_ornament_map.entrySet())
/*      */     {
/*  545 */       _size_ += CodedOutputStream.computeInt32Size(16, ((Integer)_e_.getKey()).intValue());
/*  546 */       _size_ += CodedOutputStream.computeInt64Size(16, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  548 */     _size_ += CodedOutputStream.computeMessageSize(17, this.current_pendant_ornament);
/*  549 */     _size_ += CodedOutputStream.computeMessageSize(18, this.current_rahmen_ornament);
/*  550 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : this.cross_server_send_gift.entrySet())
/*      */     {
/*  552 */       _size_ += CodedOutputStream.computeInt64Size(19, ((Long)_e_.getKey()).longValue());
/*  553 */       _size_ += CodedOutputStream.computeMessageSize(19, (Message)_e_.getValue());
/*      */     }
/*  555 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : this.cross_server_tread.entrySet())
/*      */     {
/*  557 */       _size_ += CodedOutputStream.computeInt64Size(20, ((Long)_e_.getKey()).longValue());
/*  558 */       _size_ += CodedOutputStream.computeMessageSize(20, (Message)_e_.getValue());
/*      */     }
/*  560 */     for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : this.be_sent_gift.entrySet())
/*      */     {
/*  562 */       _size_ += CodedOutputStream.computeInt64Size(21, ((Long)_e_.getKey()).longValue());
/*  563 */       _size_ += CodedOutputStream.computeMessageSize(21, (Message)_e_.getValue());
/*      */     }
/*  565 */     for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : this.be_trod_result.entrySet())
/*      */     {
/*  567 */       _size_ += CodedOutputStream.computeInt64Size(22, ((Long)_e_.getKey()).longValue());
/*  568 */       _size_ += CodedOutputStream.computeMessageSize(22, (Message)_e_.getValue());
/*      */     }
/*  570 */     for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : this.place_treasure_result.entrySet())
/*      */     {
/*  572 */       _size_ += CodedOutputStream.computeInt64Size(23, ((Long)_e_.getKey()).longValue());
/*  573 */       _size_ += CodedOutputStream.computeMessageSize(23, (Message)_e_.getValue());
/*      */     }
/*  575 */     _size_ += CodedOutputStream.computeBoolSize(24, this.update_ornament_result);
/*  576 */     _size_ += CodedOutputStream.computeInt32Size(25, this.today_get_popularity_from_tread);
/*  577 */     for (Long _v_ : this.my_black_role_list)
/*      */     {
/*  579 */       _size_ += CodedOutputStream.computeInt64Size(26, _v_.longValue());
/*      */     }
/*  581 */     for (Long _v_ : this.cross_server_black_in_role_set)
/*      */     {
/*  583 */       _size_ += CodedOutputStream.computeInt64Size(27, _v_.longValue());
/*      */     }
/*  585 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : this.cross_server_black_operator.entrySet())
/*      */     {
/*  587 */       _size_ += CodedOutputStream.computeInt64Size(28, ((Long)_e_.getKey()).longValue());
/*  588 */       _size_ += CodedOutputStream.computeMessageSize(28, (Message)_e_.getValue());
/*      */     }
/*  590 */     _size_ += CodedOutputStream.computeInt32Size(29, this.repair_tread);
/*  591 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  597 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  600 */       _output_.writeInt32(1, this.treasure_box_num);
/*  601 */       _output_.writeInt32(2, this.today_get_treasure_box_num);
/*  602 */       _output_.writeInt64(3, this.last_get_treasure_box_time);
/*  603 */       _output_.writeInt64(4, this.last_week_popularity_value_refresh_time);
/*  604 */       _output_.writeInt32(5, this.current_week_popularity_value);
/*  605 */       _output_.writeInt32(6, this.total_popularity_value);
/*  606 */       _output_.writeInt32(7, this.receive_gift_num);
/*  607 */       for (Map.Entry<Long, Integer> _e_ : this.today_tread_circle_role_id_map.entrySet())
/*      */       {
/*  609 */         _output_.writeInt64(8, ((Long)_e_.getKey()).longValue());
/*  610 */         _output_.writeInt32(8, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  612 */       _output_.writeInt64(9, this.last_tread_circle_time);
/*  613 */       for (Map.Entry<Long, Integer> _e_ : this.today_tread_my_circle_role_id_map.entrySet())
/*      */       {
/*  615 */         _output_.writeInt64(10, ((Long)_e_.getKey()).longValue());
/*  616 */         _output_.writeInt32(10, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  618 */       _output_.writeInt64(11, this.last_tread_my_circle_time);
/*  619 */       for (Map.Entry<Integer, Long> _e_ : this.own_pendant_ornament_map.entrySet())
/*      */       {
/*  621 */         _output_.writeInt32(15, ((Integer)_e_.getKey()).intValue());
/*  622 */         _output_.writeInt64(15, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  624 */       for (Map.Entry<Integer, Long> _e_ : this.own_rahmen_ornament_map.entrySet())
/*      */       {
/*  626 */         _output_.writeInt32(16, ((Integer)_e_.getKey()).intValue());
/*  627 */         _output_.writeInt64(16, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  629 */       _output_.writeMessage(17, this.current_pendant_ornament);
/*  630 */       _output_.writeMessage(18, this.current_rahmen_ornament);
/*  631 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : this.cross_server_send_gift.entrySet())
/*      */       {
/*  633 */         _output_.writeInt64(19, ((Long)_e_.getKey()).longValue());
/*  634 */         _output_.writeMessage(19, (Message)_e_.getValue());
/*      */       }
/*  636 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : this.cross_server_tread.entrySet())
/*      */       {
/*  638 */         _output_.writeInt64(20, ((Long)_e_.getKey()).longValue());
/*  639 */         _output_.writeMessage(20, (Message)_e_.getValue());
/*      */       }
/*  641 */       for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : this.be_sent_gift.entrySet())
/*      */       {
/*  643 */         _output_.writeInt64(21, ((Long)_e_.getKey()).longValue());
/*  644 */         _output_.writeMessage(21, (Message)_e_.getValue());
/*      */       }
/*  646 */       for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : this.be_trod_result.entrySet())
/*      */       {
/*  648 */         _output_.writeInt64(22, ((Long)_e_.getKey()).longValue());
/*  649 */         _output_.writeMessage(22, (Message)_e_.getValue());
/*      */       }
/*  651 */       for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : this.place_treasure_result.entrySet())
/*      */       {
/*  653 */         _output_.writeInt64(23, ((Long)_e_.getKey()).longValue());
/*  654 */         _output_.writeMessage(23, (Message)_e_.getValue());
/*      */       }
/*  656 */       _output_.writeBool(24, this.update_ornament_result);
/*  657 */       _output_.writeInt32(25, this.today_get_popularity_from_tread);
/*  658 */       for (Long _v_ : this.my_black_role_list)
/*      */       {
/*  660 */         _output_.writeInt64(26, _v_.longValue());
/*      */       }
/*  662 */       for (Long _v_ : this.cross_server_black_in_role_set)
/*      */       {
/*  664 */         _output_.writeInt64(27, _v_.longValue());
/*      */       }
/*  666 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : this.cross_server_black_operator.entrySet())
/*      */       {
/*  668 */         _output_.writeInt64(28, ((Long)_e_.getKey()).longValue());
/*  669 */         _output_.writeMessage(28, (Message)_e_.getValue());
/*      */       }
/*  671 */       _output_.writeInt32(29, this.repair_tread);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  675 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  677 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  683 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  686 */       boolean done = false;
/*  687 */       while (!done)
/*      */       {
/*  689 */         int tag = _input_.readTag();
/*  690 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  694 */           done = true;
/*  695 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  699 */           this.treasure_box_num = _input_.readInt32();
/*  700 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  704 */           this.today_get_treasure_box_num = _input_.readInt32();
/*  705 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  709 */           this.last_get_treasure_box_time = _input_.readInt64();
/*  710 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  714 */           this.last_week_popularity_value_refresh_time = _input_.readInt64();
/*  715 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  719 */           this.current_week_popularity_value = _input_.readInt32();
/*  720 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  724 */           this.total_popularity_value = _input_.readInt32();
/*  725 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  729 */           this.receive_gift_num = _input_.readInt32();
/*  730 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  734 */           long _k_ = 0L;
/*  735 */           _k_ = _input_.readInt64();
/*  736 */           int readTag = _input_.readTag();
/*  737 */           if (64 != readTag)
/*      */           {
/*  739 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  741 */           int _v_ = 0;
/*  742 */           _v_ = _input_.readInt32();
/*  743 */           this.today_tread_circle_role_id_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  744 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  748 */           this.last_tread_circle_time = _input_.readInt64();
/*  749 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  753 */           long _k_ = 0L;
/*  754 */           _k_ = _input_.readInt64();
/*  755 */           int readTag = _input_.readTag();
/*  756 */           if (80 != readTag)
/*      */           {
/*  758 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  760 */           int _v_ = 0;
/*  761 */           _v_ = _input_.readInt32();
/*  762 */           this.today_tread_my_circle_role_id_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  763 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  767 */           this.last_tread_my_circle_time = _input_.readInt64();
/*  768 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  772 */           int _k_ = 0;
/*  773 */           _k_ = _input_.readInt32();
/*  774 */           int readTag = _input_.readTag();
/*  775 */           if (120 != readTag)
/*      */           {
/*  777 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  779 */           long _v_ = 0L;
/*  780 */           _v_ = _input_.readInt64();
/*  781 */           this.own_pendant_ornament_map.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*  782 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  786 */           int _k_ = 0;
/*  787 */           _k_ = _input_.readInt32();
/*  788 */           int readTag = _input_.readTag();
/*  789 */           if (128 != readTag)
/*      */           {
/*  791 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  793 */           long _v_ = 0L;
/*  794 */           _v_ = _input_.readInt64();
/*  795 */           this.own_rahmen_ornament_map.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*  796 */           break;
/*      */         
/*      */ 
/*      */         case 138: 
/*  800 */           _input_.readMessage(this.current_pendant_ornament);
/*  801 */           break;
/*      */         
/*      */ 
/*      */         case 146: 
/*  805 */           _input_.readMessage(this.current_rahmen_ornament);
/*  806 */           break;
/*      */         
/*      */ 
/*      */         case 152: 
/*  810 */           long _k_ = 0L;
/*  811 */           _k_ = _input_.readInt64();
/*  812 */           int readTag = _input_.readTag();
/*  813 */           if (154 != readTag)
/*      */           {
/*  815 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  817 */           xbean.CrossServerFriendsCircleGift _v_ = new CrossServerFriendsCircleGift(0, this, "cross_server_send_gift");
/*  818 */           _input_.readMessage(_v_);
/*  819 */           this.cross_server_send_gift.put(Long.valueOf(_k_), _v_);
/*  820 */           break;
/*      */         
/*      */ 
/*      */         case 160: 
/*  824 */           long _k_ = 0L;
/*  825 */           _k_ = _input_.readInt64();
/*  826 */           int readTag = _input_.readTag();
/*  827 */           if (162 != readTag)
/*      */           {
/*  829 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  831 */           xbean.CrossServerFriendsCircleTread _v_ = new CrossServerFriendsCircleTread(0, this, "cross_server_tread");
/*  832 */           _input_.readMessage(_v_);
/*  833 */           this.cross_server_tread.put(Long.valueOf(_k_), _v_);
/*  834 */           break;
/*      */         
/*      */ 
/*      */         case 168: 
/*  838 */           long _k_ = 0L;
/*  839 */           _k_ = _input_.readInt64();
/*  840 */           int readTag = _input_.readTag();
/*  841 */           if (170 != readTag)
/*      */           {
/*  843 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  845 */           xbean.FriendsCircleGiftResult _v_ = new FriendsCircleGiftResult(0, this, "be_sent_gift");
/*  846 */           _input_.readMessage(_v_);
/*  847 */           this.be_sent_gift.put(Long.valueOf(_k_), _v_);
/*  848 */           break;
/*      */         
/*      */ 
/*      */         case 176: 
/*  852 */           long _k_ = 0L;
/*  853 */           _k_ = _input_.readInt64();
/*  854 */           int readTag = _input_.readTag();
/*  855 */           if (178 != readTag)
/*      */           {
/*  857 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  859 */           xbean.FriendsCircleTreadResult _v_ = new FriendsCircleTreadResult(0, this, "be_trod_result");
/*  860 */           _input_.readMessage(_v_);
/*  861 */           this.be_trod_result.put(Long.valueOf(_k_), _v_);
/*  862 */           break;
/*      */         
/*      */ 
/*      */         case 184: 
/*  866 */           long _k_ = 0L;
/*  867 */           _k_ = _input_.readInt64();
/*  868 */           int readTag = _input_.readTag();
/*  869 */           if (186 != readTag)
/*      */           {
/*  871 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  873 */           xbean.FriendsCirclePlaceTreasureResult _v_ = new FriendsCirclePlaceTreasureResult(0, this, "place_treasure_result");
/*  874 */           _input_.readMessage(_v_);
/*  875 */           this.place_treasure_result.put(Long.valueOf(_k_), _v_);
/*  876 */           break;
/*      */         
/*      */ 
/*      */         case 192: 
/*  880 */           this.update_ornament_result = _input_.readBool();
/*  881 */           break;
/*      */         
/*      */ 
/*      */         case 200: 
/*  885 */           this.today_get_popularity_from_tread = _input_.readInt32();
/*  886 */           break;
/*      */         
/*      */ 
/*      */         case 208: 
/*  890 */           long _v_ = 0L;
/*  891 */           _v_ = _input_.readInt64();
/*  892 */           this.my_black_role_list.add(Long.valueOf(_v_));
/*  893 */           break;
/*      */         
/*      */ 
/*      */         case 216: 
/*  897 */           long _v_ = 0L;
/*  898 */           _v_ = _input_.readInt64();
/*  899 */           this.cross_server_black_in_role_set.add(Long.valueOf(_v_));
/*  900 */           break;
/*      */         
/*      */ 
/*      */         case 224: 
/*  904 */           long _k_ = 0L;
/*  905 */           _k_ = _input_.readInt64();
/*  906 */           int readTag = _input_.readTag();
/*  907 */           if (226 != readTag)
/*      */           {
/*  909 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  911 */           xbean.CrossServerFriendsCircleBlackRole _v_ = new CrossServerFriendsCircleBlackRole(0, this, "cross_server_black_operator");
/*  912 */           _input_.readMessage(_v_);
/*  913 */           this.cross_server_black_operator.put(Long.valueOf(_k_), _v_);
/*  914 */           break;
/*      */         
/*      */ 
/*      */         case 232: 
/*  918 */           this.repair_tread = _input_.readInt32();
/*  919 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  923 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  925 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  934 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  938 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  940 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2FriendsCircleInfo copy()
/*      */   {
/*  946 */     _xdb_verify_unsafe_();
/*  947 */     return new Role2FriendsCircleInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2FriendsCircleInfo toData()
/*      */   {
/*  953 */     _xdb_verify_unsafe_();
/*  954 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2FriendsCircleInfo toBean()
/*      */   {
/*  959 */     _xdb_verify_unsafe_();
/*  960 */     return new Role2FriendsCircleInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2FriendsCircleInfo toDataIf()
/*      */   {
/*  966 */     _xdb_verify_unsafe_();
/*  967 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2FriendsCircleInfo toBeanIf()
/*      */   {
/*  972 */     _xdb_verify_unsafe_();
/*  973 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  979 */     _xdb_verify_unsafe_();
/*  980 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTreasure_box_num()
/*      */   {
/*  987 */     _xdb_verify_unsafe_();
/*  988 */     return this.treasure_box_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getToday_get_treasure_box_num()
/*      */   {
/*  995 */     _xdb_verify_unsafe_();
/*  996 */     return this.today_get_treasure_box_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_get_treasure_box_time()
/*      */   {
/* 1003 */     _xdb_verify_unsafe_();
/* 1004 */     return this.last_get_treasure_box_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_week_popularity_value_refresh_time()
/*      */   {
/* 1011 */     _xdb_verify_unsafe_();
/* 1012 */     return this.last_week_popularity_value_refresh_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_week_popularity_value()
/*      */   {
/* 1019 */     _xdb_verify_unsafe_();
/* 1020 */     return this.current_week_popularity_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTotal_popularity_value()
/*      */   {
/* 1027 */     _xdb_verify_unsafe_();
/* 1028 */     return this.total_popularity_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getReceive_gift_num()
/*      */   {
/* 1035 */     _xdb_verify_unsafe_();
/* 1036 */     return this.receive_gift_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getToday_tread_circle_role_id_map()
/*      */   {
/* 1043 */     _xdb_verify_unsafe_();
/* 1044 */     return Logs.logMap(new LogKey(this, "today_tread_circle_role_id_map"), this.today_tread_circle_role_id_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getToday_tread_circle_role_id_mapAsData()
/*      */   {
/* 1051 */     _xdb_verify_unsafe_();
/*      */     
/* 1053 */     Role2FriendsCircleInfo _o_ = this;
/* 1054 */     Map<Long, Integer> today_tread_circle_role_id_map = new HashMap();
/* 1055 */     for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_circle_role_id_map.entrySet())
/* 1056 */       today_tread_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/* 1057 */     return today_tread_circle_role_id_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_tread_circle_time()
/*      */   {
/* 1064 */     _xdb_verify_unsafe_();
/* 1065 */     return this.last_tread_circle_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getToday_tread_my_circle_role_id_map()
/*      */   {
/* 1072 */     _xdb_verify_unsafe_();
/* 1073 */     return Logs.logMap(new LogKey(this, "today_tread_my_circle_role_id_map"), this.today_tread_my_circle_role_id_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getToday_tread_my_circle_role_id_mapAsData()
/*      */   {
/* 1080 */     _xdb_verify_unsafe_();
/*      */     
/* 1082 */     Role2FriendsCircleInfo _o_ = this;
/* 1083 */     Map<Long, Integer> today_tread_my_circle_role_id_map = new HashMap();
/* 1084 */     for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_my_circle_role_id_map.entrySet())
/* 1085 */       today_tread_my_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/* 1086 */     return today_tread_my_circle_role_id_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_tread_my_circle_time()
/*      */   {
/* 1093 */     _xdb_verify_unsafe_();
/* 1094 */     return this.last_tread_my_circle_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getOwn_pendant_ornament_map()
/*      */   {
/* 1101 */     _xdb_verify_unsafe_();
/* 1102 */     return Logs.logMap(new LogKey(this, "own_pendant_ornament_map"), this.own_pendant_ornament_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getOwn_pendant_ornament_mapAsData()
/*      */   {
/* 1109 */     _xdb_verify_unsafe_();
/*      */     
/* 1111 */     Role2FriendsCircleInfo _o_ = this;
/* 1112 */     Map<Integer, Long> own_pendant_ornament_map = new HashMap();
/* 1113 */     for (Map.Entry<Integer, Long> _e_ : _o_.own_pendant_ornament_map.entrySet())
/* 1114 */       own_pendant_ornament_map.put(_e_.getKey(), _e_.getValue());
/* 1115 */     return own_pendant_ornament_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getOwn_rahmen_ornament_map()
/*      */   {
/* 1122 */     _xdb_verify_unsafe_();
/* 1123 */     return Logs.logMap(new LogKey(this, "own_rahmen_ornament_map"), this.own_rahmen_ornament_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getOwn_rahmen_ornament_mapAsData()
/*      */   {
/* 1130 */     _xdb_verify_unsafe_();
/*      */     
/* 1132 */     Role2FriendsCircleInfo _o_ = this;
/* 1133 */     Map<Integer, Long> own_rahmen_ornament_map = new HashMap();
/* 1134 */     for (Map.Entry<Integer, Long> _e_ : _o_.own_rahmen_ornament_map.entrySet())
/* 1135 */       own_rahmen_ornament_map.put(_e_.getKey(), _e_.getValue());
/* 1136 */     return own_rahmen_ornament_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.FriendsCircleOrnamentItem getCurrent_pendant_ornament()
/*      */   {
/* 1143 */     _xdb_verify_unsafe_();
/* 1144 */     return this.current_pendant_ornament;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.FriendsCircleOrnamentItem getCurrent_rahmen_ornament()
/*      */   {
/* 1151 */     _xdb_verify_unsafe_();
/* 1152 */     return this.current_rahmen_ornament;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.CrossServerFriendsCircleGift> getCross_server_send_gift()
/*      */   {
/* 1159 */     _xdb_verify_unsafe_();
/* 1160 */     return Logs.logMap(new LogKey(this, "cross_server_send_gift"), this.cross_server_send_gift);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.CrossServerFriendsCircleGift> getCross_server_send_giftAsData()
/*      */   {
/* 1167 */     _xdb_verify_unsafe_();
/*      */     
/* 1169 */     Role2FriendsCircleInfo _o_ = this;
/* 1170 */     Map<Long, xbean.CrossServerFriendsCircleGift> cross_server_send_gift = new HashMap();
/* 1171 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : _o_.cross_server_send_gift.entrySet())
/* 1172 */       cross_server_send_gift.put(_e_.getKey(), new CrossServerFriendsCircleGift.Data((xbean.CrossServerFriendsCircleGift)_e_.getValue()));
/* 1173 */     return cross_server_send_gift;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.CrossServerFriendsCircleTread> getCross_server_tread()
/*      */   {
/* 1180 */     _xdb_verify_unsafe_();
/* 1181 */     return Logs.logMap(new LogKey(this, "cross_server_tread"), this.cross_server_tread);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.CrossServerFriendsCircleTread> getCross_server_treadAsData()
/*      */   {
/* 1188 */     _xdb_verify_unsafe_();
/*      */     
/* 1190 */     Role2FriendsCircleInfo _o_ = this;
/* 1191 */     Map<Long, xbean.CrossServerFriendsCircleTread> cross_server_tread = new HashMap();
/* 1192 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : _o_.cross_server_tread.entrySet())
/* 1193 */       cross_server_tread.put(_e_.getKey(), new CrossServerFriendsCircleTread.Data((xbean.CrossServerFriendsCircleTread)_e_.getValue()));
/* 1194 */     return cross_server_tread;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.FriendsCircleGiftResult> getBe_sent_gift()
/*      */   {
/* 1201 */     _xdb_verify_unsafe_();
/* 1202 */     return Logs.logMap(new LogKey(this, "be_sent_gift"), this.be_sent_gift);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.FriendsCircleGiftResult> getBe_sent_giftAsData()
/*      */   {
/* 1209 */     _xdb_verify_unsafe_();
/*      */     
/* 1211 */     Role2FriendsCircleInfo _o_ = this;
/* 1212 */     Map<Long, xbean.FriendsCircleGiftResult> be_sent_gift = new HashMap();
/* 1213 */     for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : _o_.be_sent_gift.entrySet())
/* 1214 */       be_sent_gift.put(_e_.getKey(), new FriendsCircleGiftResult.Data((xbean.FriendsCircleGiftResult)_e_.getValue()));
/* 1215 */     return be_sent_gift;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.FriendsCircleTreadResult> getBe_trod_result()
/*      */   {
/* 1222 */     _xdb_verify_unsafe_();
/* 1223 */     return Logs.logMap(new LogKey(this, "be_trod_result"), this.be_trod_result);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.FriendsCircleTreadResult> getBe_trod_resultAsData()
/*      */   {
/* 1230 */     _xdb_verify_unsafe_();
/*      */     
/* 1232 */     Role2FriendsCircleInfo _o_ = this;
/* 1233 */     Map<Long, xbean.FriendsCircleTreadResult> be_trod_result = new HashMap();
/* 1234 */     for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : _o_.be_trod_result.entrySet())
/* 1235 */       be_trod_result.put(_e_.getKey(), new FriendsCircleTreadResult.Data((xbean.FriendsCircleTreadResult)_e_.getValue()));
/* 1236 */     return be_trod_result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.FriendsCirclePlaceTreasureResult> getPlace_treasure_result()
/*      */   {
/* 1243 */     _xdb_verify_unsafe_();
/* 1244 */     return Logs.logMap(new LogKey(this, "place_treasure_result"), this.place_treasure_result);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.FriendsCirclePlaceTreasureResult> getPlace_treasure_resultAsData()
/*      */   {
/* 1251 */     _xdb_verify_unsafe_();
/*      */     
/* 1253 */     Role2FriendsCircleInfo _o_ = this;
/* 1254 */     Map<Long, xbean.FriendsCirclePlaceTreasureResult> place_treasure_result = new HashMap();
/* 1255 */     for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : _o_.place_treasure_result.entrySet())
/* 1256 */       place_treasure_result.put(_e_.getKey(), new FriendsCirclePlaceTreasureResult.Data((xbean.FriendsCirclePlaceTreasureResult)_e_.getValue()));
/* 1257 */     return place_treasure_result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getUpdate_ornament_result()
/*      */   {
/* 1264 */     _xdb_verify_unsafe_();
/* 1265 */     return this.update_ornament_result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getToday_get_popularity_from_tread()
/*      */   {
/* 1272 */     _xdb_verify_unsafe_();
/* 1273 */     return this.today_get_popularity_from_tread;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getMy_black_role_list()
/*      */   {
/* 1280 */     _xdb_verify_unsafe_();
/* 1281 */     return Logs.logList(new LogKey(this, "my_black_role_list"), this.my_black_role_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getMy_black_role_listAsData()
/*      */   {
/* 1287 */     _xdb_verify_unsafe_();
/*      */     
/* 1289 */     Role2FriendsCircleInfo _o_ = this;
/* 1290 */     List<Long> my_black_role_list = new ArrayList();
/* 1291 */     my_black_role_list.addAll(_o_.my_black_role_list);
/* 1292 */     return my_black_role_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getCross_server_black_in_role_set()
/*      */   {
/* 1299 */     _xdb_verify_unsafe_();
/* 1300 */     return Logs.logSet(new LogKey(this, "cross_server_black_in_role_set"), this.cross_server_black_in_role_set);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getCross_server_black_in_role_setAsData()
/*      */   {
/* 1306 */     _xdb_verify_unsafe_();
/*      */     
/* 1308 */     Role2FriendsCircleInfo _o_ = this;
/* 1309 */     Set<Long> cross_server_black_in_role_set = new SetX();
/* 1310 */     cross_server_black_in_role_set.addAll(_o_.cross_server_black_in_role_set);
/* 1311 */     return cross_server_black_in_role_set;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.CrossServerFriendsCircleBlackRole> getCross_server_black_operator()
/*      */   {
/* 1318 */     _xdb_verify_unsafe_();
/* 1319 */     return Logs.logMap(new LogKey(this, "cross_server_black_operator"), this.cross_server_black_operator);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.CrossServerFriendsCircleBlackRole> getCross_server_black_operatorAsData()
/*      */   {
/* 1326 */     _xdb_verify_unsafe_();
/*      */     
/* 1328 */     Role2FriendsCircleInfo _o_ = this;
/* 1329 */     Map<Long, xbean.CrossServerFriendsCircleBlackRole> cross_server_black_operator = new HashMap();
/* 1330 */     for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : _o_.cross_server_black_operator.entrySet())
/* 1331 */       cross_server_black_operator.put(_e_.getKey(), new CrossServerFriendsCircleBlackRole.Data((xbean.CrossServerFriendsCircleBlackRole)_e_.getValue()));
/* 1332 */     return cross_server_black_operator;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRepair_tread()
/*      */   {
/* 1339 */     _xdb_verify_unsafe_();
/* 1340 */     return this.repair_tread;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTreasure_box_num(int _v_)
/*      */   {
/* 1347 */     _xdb_verify_unsafe_();
/* 1348 */     Logs.logIf(new LogKey(this, "treasure_box_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1352 */         new LogInt(this, Role2FriendsCircleInfo.this.treasure_box_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1356 */             Role2FriendsCircleInfo.this.treasure_box_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1360 */     });
/* 1361 */     this.treasure_box_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setToday_get_treasure_box_num(int _v_)
/*      */   {
/* 1368 */     _xdb_verify_unsafe_();
/* 1369 */     Logs.logIf(new LogKey(this, "today_get_treasure_box_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1373 */         new LogInt(this, Role2FriendsCircleInfo.this.today_get_treasure_box_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1377 */             Role2FriendsCircleInfo.this.today_get_treasure_box_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1381 */     });
/* 1382 */     this.today_get_treasure_box_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_get_treasure_box_time(long _v_)
/*      */   {
/* 1389 */     _xdb_verify_unsafe_();
/* 1390 */     Logs.logIf(new LogKey(this, "last_get_treasure_box_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1394 */         new LogLong(this, Role2FriendsCircleInfo.this.last_get_treasure_box_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1398 */             Role2FriendsCircleInfo.this.last_get_treasure_box_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1402 */     });
/* 1403 */     this.last_get_treasure_box_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_week_popularity_value_refresh_time(long _v_)
/*      */   {
/* 1410 */     _xdb_verify_unsafe_();
/* 1411 */     Logs.logIf(new LogKey(this, "last_week_popularity_value_refresh_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1415 */         new LogLong(this, Role2FriendsCircleInfo.this.last_week_popularity_value_refresh_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1419 */             Role2FriendsCircleInfo.this.last_week_popularity_value_refresh_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1423 */     });
/* 1424 */     this.last_week_popularity_value_refresh_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_week_popularity_value(int _v_)
/*      */   {
/* 1431 */     _xdb_verify_unsafe_();
/* 1432 */     Logs.logIf(new LogKey(this, "current_week_popularity_value")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1436 */         new LogInt(this, Role2FriendsCircleInfo.this.current_week_popularity_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1440 */             Role2FriendsCircleInfo.this.current_week_popularity_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1444 */     });
/* 1445 */     this.current_week_popularity_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_popularity_value(int _v_)
/*      */   {
/* 1452 */     _xdb_verify_unsafe_();
/* 1453 */     Logs.logIf(new LogKey(this, "total_popularity_value")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1457 */         new LogInt(this, Role2FriendsCircleInfo.this.total_popularity_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1461 */             Role2FriendsCircleInfo.this.total_popularity_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1465 */     });
/* 1466 */     this.total_popularity_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReceive_gift_num(int _v_)
/*      */   {
/* 1473 */     _xdb_verify_unsafe_();
/* 1474 */     Logs.logIf(new LogKey(this, "receive_gift_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1478 */         new LogInt(this, Role2FriendsCircleInfo.this.receive_gift_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1482 */             Role2FriendsCircleInfo.this.receive_gift_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1486 */     });
/* 1487 */     this.receive_gift_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_tread_circle_time(long _v_)
/*      */   {
/* 1494 */     _xdb_verify_unsafe_();
/* 1495 */     Logs.logIf(new LogKey(this, "last_tread_circle_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1499 */         new LogLong(this, Role2FriendsCircleInfo.this.last_tread_circle_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1503 */             Role2FriendsCircleInfo.this.last_tread_circle_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1507 */     });
/* 1508 */     this.last_tread_circle_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_tread_my_circle_time(long _v_)
/*      */   {
/* 1515 */     _xdb_verify_unsafe_();
/* 1516 */     Logs.logIf(new LogKey(this, "last_tread_my_circle_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1520 */         new LogLong(this, Role2FriendsCircleInfo.this.last_tread_my_circle_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1524 */             Role2FriendsCircleInfo.this.last_tread_my_circle_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1528 */     });
/* 1529 */     this.last_tread_my_circle_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUpdate_ornament_result(boolean _v_)
/*      */   {
/* 1536 */     _xdb_verify_unsafe_();
/* 1537 */     Logs.logIf(new LogKey(this, "update_ornament_result")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1541 */         new LogObject(this, Boolean.valueOf(Role2FriendsCircleInfo.this.update_ornament_result))
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1545 */             Role2FriendsCircleInfo.this.update_ornament_result = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/* 1549 */     });
/* 1550 */     this.update_ornament_result = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setToday_get_popularity_from_tread(int _v_)
/*      */   {
/* 1557 */     _xdb_verify_unsafe_();
/* 1558 */     Logs.logIf(new LogKey(this, "today_get_popularity_from_tread")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1562 */         new LogInt(this, Role2FriendsCircleInfo.this.today_get_popularity_from_tread)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1566 */             Role2FriendsCircleInfo.this.today_get_popularity_from_tread = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1570 */     });
/* 1571 */     this.today_get_popularity_from_tread = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRepair_tread(int _v_)
/*      */   {
/* 1578 */     _xdb_verify_unsafe_();
/* 1579 */     Logs.logIf(new LogKey(this, "repair_tread")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1583 */         new LogInt(this, Role2FriendsCircleInfo.this.repair_tread)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1587 */             Role2FriendsCircleInfo.this.repair_tread = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1591 */     });
/* 1592 */     this.repair_tread = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1598 */     _xdb_verify_unsafe_();
/* 1599 */     Role2FriendsCircleInfo _o_ = null;
/* 1600 */     if ((_o1_ instanceof Role2FriendsCircleInfo)) { _o_ = (Role2FriendsCircleInfo)_o1_;
/* 1601 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1602 */       return false;
/* 1603 */     if (this.treasure_box_num != _o_.treasure_box_num) return false;
/* 1604 */     if (this.today_get_treasure_box_num != _o_.today_get_treasure_box_num) return false;
/* 1605 */     if (this.last_get_treasure_box_time != _o_.last_get_treasure_box_time) return false;
/* 1606 */     if (this.last_week_popularity_value_refresh_time != _o_.last_week_popularity_value_refresh_time) return false;
/* 1607 */     if (this.current_week_popularity_value != _o_.current_week_popularity_value) return false;
/* 1608 */     if (this.total_popularity_value != _o_.total_popularity_value) return false;
/* 1609 */     if (this.receive_gift_num != _o_.receive_gift_num) return false;
/* 1610 */     if (!this.today_tread_circle_role_id_map.equals(_o_.today_tread_circle_role_id_map)) return false;
/* 1611 */     if (this.last_tread_circle_time != _o_.last_tread_circle_time) return false;
/* 1612 */     if (!this.today_tread_my_circle_role_id_map.equals(_o_.today_tread_my_circle_role_id_map)) return false;
/* 1613 */     if (this.last_tread_my_circle_time != _o_.last_tread_my_circle_time) return false;
/* 1614 */     if (!this.own_pendant_ornament_map.equals(_o_.own_pendant_ornament_map)) return false;
/* 1615 */     if (!this.own_rahmen_ornament_map.equals(_o_.own_rahmen_ornament_map)) return false;
/* 1616 */     if (!this.current_pendant_ornament.equals(_o_.current_pendant_ornament)) return false;
/* 1617 */     if (!this.current_rahmen_ornament.equals(_o_.current_rahmen_ornament)) return false;
/* 1618 */     if (!this.cross_server_send_gift.equals(_o_.cross_server_send_gift)) return false;
/* 1619 */     if (!this.cross_server_tread.equals(_o_.cross_server_tread)) return false;
/* 1620 */     if (!this.be_sent_gift.equals(_o_.be_sent_gift)) return false;
/* 1621 */     if (!this.be_trod_result.equals(_o_.be_trod_result)) return false;
/* 1622 */     if (!this.place_treasure_result.equals(_o_.place_treasure_result)) return false;
/* 1623 */     if (this.update_ornament_result != _o_.update_ornament_result) return false;
/* 1624 */     if (this.today_get_popularity_from_tread != _o_.today_get_popularity_from_tread) return false;
/* 1625 */     if (!this.my_black_role_list.equals(_o_.my_black_role_list)) return false;
/* 1626 */     if (!this.cross_server_black_in_role_set.equals(_o_.cross_server_black_in_role_set)) return false;
/* 1627 */     if (!this.cross_server_black_operator.equals(_o_.cross_server_black_operator)) return false;
/* 1628 */     if (this.repair_tread != _o_.repair_tread) return false;
/* 1629 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1635 */     _xdb_verify_unsafe_();
/* 1636 */     int _h_ = 0;
/* 1637 */     _h_ += this.treasure_box_num;
/* 1638 */     _h_ += this.today_get_treasure_box_num;
/* 1639 */     _h_ = (int)(_h_ + this.last_get_treasure_box_time);
/* 1640 */     _h_ = (int)(_h_ + this.last_week_popularity_value_refresh_time);
/* 1641 */     _h_ += this.current_week_popularity_value;
/* 1642 */     _h_ += this.total_popularity_value;
/* 1643 */     _h_ += this.receive_gift_num;
/* 1644 */     _h_ += this.today_tread_circle_role_id_map.hashCode();
/* 1645 */     _h_ = (int)(_h_ + this.last_tread_circle_time);
/* 1646 */     _h_ += this.today_tread_my_circle_role_id_map.hashCode();
/* 1647 */     _h_ = (int)(_h_ + this.last_tread_my_circle_time);
/* 1648 */     _h_ += this.own_pendant_ornament_map.hashCode();
/* 1649 */     _h_ += this.own_rahmen_ornament_map.hashCode();
/* 1650 */     _h_ += this.current_pendant_ornament.hashCode();
/* 1651 */     _h_ += this.current_rahmen_ornament.hashCode();
/* 1652 */     _h_ += this.cross_server_send_gift.hashCode();
/* 1653 */     _h_ += this.cross_server_tread.hashCode();
/* 1654 */     _h_ += this.be_sent_gift.hashCode();
/* 1655 */     _h_ += this.be_trod_result.hashCode();
/* 1656 */     _h_ += this.place_treasure_result.hashCode();
/* 1657 */     _h_ += (this.update_ornament_result ? 1231 : 1237);
/* 1658 */     _h_ += this.today_get_popularity_from_tread;
/* 1659 */     _h_ += this.my_black_role_list.hashCode();
/* 1660 */     _h_ += this.cross_server_black_in_role_set.hashCode();
/* 1661 */     _h_ += this.cross_server_black_operator.hashCode();
/* 1662 */     _h_ += this.repair_tread;
/* 1663 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1669 */     _xdb_verify_unsafe_();
/* 1670 */     StringBuilder _sb_ = new StringBuilder();
/* 1671 */     _sb_.append("(");
/* 1672 */     _sb_.append(this.treasure_box_num);
/* 1673 */     _sb_.append(",");
/* 1674 */     _sb_.append(this.today_get_treasure_box_num);
/* 1675 */     _sb_.append(",");
/* 1676 */     _sb_.append(this.last_get_treasure_box_time);
/* 1677 */     _sb_.append(",");
/* 1678 */     _sb_.append(this.last_week_popularity_value_refresh_time);
/* 1679 */     _sb_.append(",");
/* 1680 */     _sb_.append(this.current_week_popularity_value);
/* 1681 */     _sb_.append(",");
/* 1682 */     _sb_.append(this.total_popularity_value);
/* 1683 */     _sb_.append(",");
/* 1684 */     _sb_.append(this.receive_gift_num);
/* 1685 */     _sb_.append(",");
/* 1686 */     _sb_.append(this.today_tread_circle_role_id_map);
/* 1687 */     _sb_.append(",");
/* 1688 */     _sb_.append(this.last_tread_circle_time);
/* 1689 */     _sb_.append(",");
/* 1690 */     _sb_.append(this.today_tread_my_circle_role_id_map);
/* 1691 */     _sb_.append(",");
/* 1692 */     _sb_.append(this.last_tread_my_circle_time);
/* 1693 */     _sb_.append(",");
/* 1694 */     _sb_.append(this.own_pendant_ornament_map);
/* 1695 */     _sb_.append(",");
/* 1696 */     _sb_.append(this.own_rahmen_ornament_map);
/* 1697 */     _sb_.append(",");
/* 1698 */     _sb_.append(this.current_pendant_ornament);
/* 1699 */     _sb_.append(",");
/* 1700 */     _sb_.append(this.current_rahmen_ornament);
/* 1701 */     _sb_.append(",");
/* 1702 */     _sb_.append(this.cross_server_send_gift);
/* 1703 */     _sb_.append(",");
/* 1704 */     _sb_.append(this.cross_server_tread);
/* 1705 */     _sb_.append(",");
/* 1706 */     _sb_.append(this.be_sent_gift);
/* 1707 */     _sb_.append(",");
/* 1708 */     _sb_.append(this.be_trod_result);
/* 1709 */     _sb_.append(",");
/* 1710 */     _sb_.append(this.place_treasure_result);
/* 1711 */     _sb_.append(",");
/* 1712 */     _sb_.append(this.update_ornament_result);
/* 1713 */     _sb_.append(",");
/* 1714 */     _sb_.append(this.today_get_popularity_from_tread);
/* 1715 */     _sb_.append(",");
/* 1716 */     _sb_.append(this.my_black_role_list);
/* 1717 */     _sb_.append(",");
/* 1718 */     _sb_.append(this.cross_server_black_in_role_set);
/* 1719 */     _sb_.append(",");
/* 1720 */     _sb_.append(this.cross_server_black_operator);
/* 1721 */     _sb_.append(",");
/* 1722 */     _sb_.append(this.repair_tread);
/* 1723 */     _sb_.append(")");
/* 1724 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1730 */     ListenableBean lb = new ListenableBean();
/* 1731 */     lb.add(new ListenableChanged().setVarName("treasure_box_num"));
/* 1732 */     lb.add(new ListenableChanged().setVarName("today_get_treasure_box_num"));
/* 1733 */     lb.add(new ListenableChanged().setVarName("last_get_treasure_box_time"));
/* 1734 */     lb.add(new ListenableChanged().setVarName("last_week_popularity_value_refresh_time"));
/* 1735 */     lb.add(new ListenableChanged().setVarName("current_week_popularity_value"));
/* 1736 */     lb.add(new ListenableChanged().setVarName("total_popularity_value"));
/* 1737 */     lb.add(new ListenableChanged().setVarName("receive_gift_num"));
/* 1738 */     lb.add(new ListenableMap().setVarName("today_tread_circle_role_id_map"));
/* 1739 */     lb.add(new ListenableChanged().setVarName("last_tread_circle_time"));
/* 1740 */     lb.add(new ListenableMap().setVarName("today_tread_my_circle_role_id_map"));
/* 1741 */     lb.add(new ListenableChanged().setVarName("last_tread_my_circle_time"));
/* 1742 */     lb.add(new ListenableMap().setVarName("own_pendant_ornament_map"));
/* 1743 */     lb.add(new ListenableMap().setVarName("own_rahmen_ornament_map"));
/* 1744 */     lb.add(new ListenableChanged().setVarName("current_pendant_ornament"));
/* 1745 */     lb.add(new ListenableChanged().setVarName("current_rahmen_ornament"));
/* 1746 */     lb.add(new ListenableMap().setVarName("cross_server_send_gift"));
/* 1747 */     lb.add(new ListenableMap().setVarName("cross_server_tread"));
/* 1748 */     lb.add(new ListenableMap().setVarName("be_sent_gift"));
/* 1749 */     lb.add(new ListenableMap().setVarName("be_trod_result"));
/* 1750 */     lb.add(new ListenableMap().setVarName("place_treasure_result"));
/* 1751 */     lb.add(new ListenableChanged().setVarName("update_ornament_result"));
/* 1752 */     lb.add(new ListenableChanged().setVarName("today_get_popularity_from_tread"));
/* 1753 */     lb.add(new ListenableChanged().setVarName("my_black_role_list"));
/* 1754 */     lb.add(new ListenableSet().setVarName("cross_server_black_in_role_set"));
/* 1755 */     lb.add(new ListenableMap().setVarName("cross_server_black_operator"));
/* 1756 */     lb.add(new ListenableChanged().setVarName("repair_tread"));
/* 1757 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Role2FriendsCircleInfo {
/*      */     private Const() {}
/*      */     
/*      */     Role2FriendsCircleInfo nThis() {
/* 1764 */       return Role2FriendsCircleInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1770 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FriendsCircleInfo copy()
/*      */     {
/* 1776 */       return Role2FriendsCircleInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FriendsCircleInfo toData()
/*      */     {
/* 1782 */       return Role2FriendsCircleInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Role2FriendsCircleInfo toBean()
/*      */     {
/* 1787 */       return Role2FriendsCircleInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FriendsCircleInfo toDataIf()
/*      */     {
/* 1793 */       return Role2FriendsCircleInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Role2FriendsCircleInfo toBeanIf()
/*      */     {
/* 1798 */       return Role2FriendsCircleInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTreasure_box_num()
/*      */     {
/* 1805 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1806 */       return Role2FriendsCircleInfo.this.treasure_box_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getToday_get_treasure_box_num()
/*      */     {
/* 1813 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1814 */       return Role2FriendsCircleInfo.this.today_get_treasure_box_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_get_treasure_box_time()
/*      */     {
/* 1821 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1822 */       return Role2FriendsCircleInfo.this.last_get_treasure_box_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_week_popularity_value_refresh_time()
/*      */     {
/* 1829 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1830 */       return Role2FriendsCircleInfo.this.last_week_popularity_value_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_week_popularity_value()
/*      */     {
/* 1837 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1838 */       return Role2FriendsCircleInfo.this.current_week_popularity_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_popularity_value()
/*      */     {
/* 1845 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1846 */       return Role2FriendsCircleInfo.this.total_popularity_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReceive_gift_num()
/*      */     {
/* 1853 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1854 */       return Role2FriendsCircleInfo.this.receive_gift_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getToday_tread_circle_role_id_map()
/*      */     {
/* 1861 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1862 */       return Consts.constMap(Role2FriendsCircleInfo.this.today_tread_circle_role_id_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getToday_tread_circle_role_id_mapAsData()
/*      */     {
/* 1869 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1871 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 1872 */       Map<Long, Integer> today_tread_circle_role_id_map = new HashMap();
/* 1873 */       for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_circle_role_id_map.entrySet())
/* 1874 */         today_tread_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/* 1875 */       return today_tread_circle_role_id_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_tread_circle_time()
/*      */     {
/* 1882 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1883 */       return Role2FriendsCircleInfo.this.last_tread_circle_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getToday_tread_my_circle_role_id_map()
/*      */     {
/* 1890 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1891 */       return Consts.constMap(Role2FriendsCircleInfo.this.today_tread_my_circle_role_id_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getToday_tread_my_circle_role_id_mapAsData()
/*      */     {
/* 1898 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1900 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 1901 */       Map<Long, Integer> today_tread_my_circle_role_id_map = new HashMap();
/* 1902 */       for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_my_circle_role_id_map.entrySet())
/* 1903 */         today_tread_my_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/* 1904 */       return today_tread_my_circle_role_id_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_tread_my_circle_time()
/*      */     {
/* 1911 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1912 */       return Role2FriendsCircleInfo.this.last_tread_my_circle_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getOwn_pendant_ornament_map()
/*      */     {
/* 1919 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1920 */       return Consts.constMap(Role2FriendsCircleInfo.this.own_pendant_ornament_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getOwn_pendant_ornament_mapAsData()
/*      */     {
/* 1927 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1929 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 1930 */       Map<Integer, Long> own_pendant_ornament_map = new HashMap();
/* 1931 */       for (Map.Entry<Integer, Long> _e_ : _o_.own_pendant_ornament_map.entrySet())
/* 1932 */         own_pendant_ornament_map.put(_e_.getKey(), _e_.getValue());
/* 1933 */       return own_pendant_ornament_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getOwn_rahmen_ornament_map()
/*      */     {
/* 1940 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1941 */       return Consts.constMap(Role2FriendsCircleInfo.this.own_rahmen_ornament_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getOwn_rahmen_ornament_mapAsData()
/*      */     {
/* 1948 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1950 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 1951 */       Map<Integer, Long> own_rahmen_ornament_map = new HashMap();
/* 1952 */       for (Map.Entry<Integer, Long> _e_ : _o_.own_rahmen_ornament_map.entrySet())
/* 1953 */         own_rahmen_ornament_map.put(_e_.getKey(), _e_.getValue());
/* 1954 */       return own_rahmen_ornament_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FriendsCircleOrnamentItem getCurrent_pendant_ornament()
/*      */     {
/* 1961 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1962 */       return (xbean.FriendsCircleOrnamentItem)Consts.toConst(Role2FriendsCircleInfo.this.current_pendant_ornament);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FriendsCircleOrnamentItem getCurrent_rahmen_ornament()
/*      */     {
/* 1969 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1970 */       return (xbean.FriendsCircleOrnamentItem)Consts.toConst(Role2FriendsCircleInfo.this.current_rahmen_ornament);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleGift> getCross_server_send_gift()
/*      */     {
/* 1977 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1978 */       return Consts.constMap(Role2FriendsCircleInfo.this.cross_server_send_gift);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleGift> getCross_server_send_giftAsData()
/*      */     {
/* 1985 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1987 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 1988 */       Map<Long, xbean.CrossServerFriendsCircleGift> cross_server_send_gift = new HashMap();
/* 1989 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : _o_.cross_server_send_gift.entrySet())
/* 1990 */         cross_server_send_gift.put(_e_.getKey(), new CrossServerFriendsCircleGift.Data((xbean.CrossServerFriendsCircleGift)_e_.getValue()));
/* 1991 */       return cross_server_send_gift;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleTread> getCross_server_tread()
/*      */     {
/* 1998 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 1999 */       return Consts.constMap(Role2FriendsCircleInfo.this.cross_server_tread);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleTread> getCross_server_treadAsData()
/*      */     {
/* 2006 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 2008 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 2009 */       Map<Long, xbean.CrossServerFriendsCircleTread> cross_server_tread = new HashMap();
/* 2010 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : _o_.cross_server_tread.entrySet())
/* 2011 */         cross_server_tread.put(_e_.getKey(), new CrossServerFriendsCircleTread.Data((xbean.CrossServerFriendsCircleTread)_e_.getValue()));
/* 2012 */       return cross_server_tread;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCircleGiftResult> getBe_sent_gift()
/*      */     {
/* 2019 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2020 */       return Consts.constMap(Role2FriendsCircleInfo.this.be_sent_gift);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCircleGiftResult> getBe_sent_giftAsData()
/*      */     {
/* 2027 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 2029 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 2030 */       Map<Long, xbean.FriendsCircleGiftResult> be_sent_gift = new HashMap();
/* 2031 */       for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : _o_.be_sent_gift.entrySet())
/* 2032 */         be_sent_gift.put(_e_.getKey(), new FriendsCircleGiftResult.Data((xbean.FriendsCircleGiftResult)_e_.getValue()));
/* 2033 */       return be_sent_gift;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCircleTreadResult> getBe_trod_result()
/*      */     {
/* 2040 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2041 */       return Consts.constMap(Role2FriendsCircleInfo.this.be_trod_result);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCircleTreadResult> getBe_trod_resultAsData()
/*      */     {
/* 2048 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 2050 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 2051 */       Map<Long, xbean.FriendsCircleTreadResult> be_trod_result = new HashMap();
/* 2052 */       for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : _o_.be_trod_result.entrySet())
/* 2053 */         be_trod_result.put(_e_.getKey(), new FriendsCircleTreadResult.Data((xbean.FriendsCircleTreadResult)_e_.getValue()));
/* 2054 */       return be_trod_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCirclePlaceTreasureResult> getPlace_treasure_result()
/*      */     {
/* 2061 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2062 */       return Consts.constMap(Role2FriendsCircleInfo.this.place_treasure_result);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCirclePlaceTreasureResult> getPlace_treasure_resultAsData()
/*      */     {
/* 2069 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 2071 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 2072 */       Map<Long, xbean.FriendsCirclePlaceTreasureResult> place_treasure_result = new HashMap();
/* 2073 */       for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : _o_.place_treasure_result.entrySet())
/* 2074 */         place_treasure_result.put(_e_.getKey(), new FriendsCirclePlaceTreasureResult.Data((xbean.FriendsCirclePlaceTreasureResult)_e_.getValue()));
/* 2075 */       return place_treasure_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getUpdate_ornament_result()
/*      */     {
/* 2082 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2083 */       return Role2FriendsCircleInfo.this.update_ornament_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getToday_get_popularity_from_tread()
/*      */     {
/* 2090 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2091 */       return Role2FriendsCircleInfo.this.today_get_popularity_from_tread;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMy_black_role_list()
/*      */     {
/* 2098 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2099 */       return Consts.constList(Role2FriendsCircleInfo.this.my_black_role_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getMy_black_role_listAsData()
/*      */     {
/* 2105 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 2107 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 2108 */       List<Long> my_black_role_list = new ArrayList();
/* 2109 */       my_black_role_list.addAll(_o_.my_black_role_list);
/* 2110 */       return my_black_role_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCross_server_black_in_role_set()
/*      */     {
/* 2117 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2118 */       return Consts.constSet(Role2FriendsCircleInfo.this.cross_server_black_in_role_set);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getCross_server_black_in_role_setAsData()
/*      */     {
/* 2124 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 2126 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 2127 */       Set<Long> cross_server_black_in_role_set = new SetX();
/* 2128 */       cross_server_black_in_role_set.addAll(_o_.cross_server_black_in_role_set);
/* 2129 */       return cross_server_black_in_role_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleBlackRole> getCross_server_black_operator()
/*      */     {
/* 2136 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2137 */       return Consts.constMap(Role2FriendsCircleInfo.this.cross_server_black_operator);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleBlackRole> getCross_server_black_operatorAsData()
/*      */     {
/* 2144 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/*      */       
/* 2146 */       Role2FriendsCircleInfo _o_ = Role2FriendsCircleInfo.this;
/* 2147 */       Map<Long, xbean.CrossServerFriendsCircleBlackRole> cross_server_black_operator = new HashMap();
/* 2148 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : _o_.cross_server_black_operator.entrySet())
/* 2149 */         cross_server_black_operator.put(_e_.getKey(), new CrossServerFriendsCircleBlackRole.Data((xbean.CrossServerFriendsCircleBlackRole)_e_.getValue()));
/* 2150 */       return cross_server_black_operator;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRepair_tread()
/*      */     {
/* 2157 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2158 */       return Role2FriendsCircleInfo.this.repair_tread;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTreasure_box_num(int _v_)
/*      */     {
/* 2165 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2166 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setToday_get_treasure_box_num(int _v_)
/*      */     {
/* 2173 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2174 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_get_treasure_box_time(long _v_)
/*      */     {
/* 2181 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2182 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_week_popularity_value_refresh_time(long _v_)
/*      */     {
/* 2189 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2190 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_week_popularity_value(int _v_)
/*      */     {
/* 2197 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2198 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_popularity_value(int _v_)
/*      */     {
/* 2205 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2206 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReceive_gift_num(int _v_)
/*      */     {
/* 2213 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2214 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_tread_circle_time(long _v_)
/*      */     {
/* 2221 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2222 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_tread_my_circle_time(long _v_)
/*      */     {
/* 2229 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2230 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdate_ornament_result(boolean _v_)
/*      */     {
/* 2237 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2238 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setToday_get_popularity_from_tread(int _v_)
/*      */     {
/* 2245 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2246 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRepair_tread(int _v_)
/*      */     {
/* 2253 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2254 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 2260 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2261 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 2267 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2268 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 2274 */       return Role2FriendsCircleInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2280 */       return Role2FriendsCircleInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2286 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2287 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 2293 */       return Role2FriendsCircleInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2299 */       return Role2FriendsCircleInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2305 */       Role2FriendsCircleInfo.this._xdb_verify_unsafe_();
/* 2306 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 2312 */       return Role2FriendsCircleInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2318 */       return Role2FriendsCircleInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 2324 */       return Role2FriendsCircleInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 2330 */       return Role2FriendsCircleInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 2336 */       return Role2FriendsCircleInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 2342 */       return Role2FriendsCircleInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2348 */       return Role2FriendsCircleInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Role2FriendsCircleInfo
/*      */   {
/*      */     private int treasure_box_num;
/*      */     
/*      */     private int today_get_treasure_box_num;
/*      */     
/*      */     private long last_get_treasure_box_time;
/*      */     
/*      */     private long last_week_popularity_value_refresh_time;
/*      */     
/*      */     private int current_week_popularity_value;
/*      */     
/*      */     private int total_popularity_value;
/*      */     
/*      */     private int receive_gift_num;
/*      */     
/*      */     private HashMap<Long, Integer> today_tread_circle_role_id_map;
/*      */     
/*      */     private long last_tread_circle_time;
/*      */     
/*      */     private HashMap<Long, Integer> today_tread_my_circle_role_id_map;
/*      */     
/*      */     private long last_tread_my_circle_time;
/*      */     
/*      */     private HashMap<Integer, Long> own_pendant_ornament_map;
/*      */     
/*      */     private HashMap<Integer, Long> own_rahmen_ornament_map;
/*      */     
/*      */     private xbean.FriendsCircleOrnamentItem current_pendant_ornament;
/*      */     
/*      */     private xbean.FriendsCircleOrnamentItem current_rahmen_ornament;
/*      */     
/*      */     private HashMap<Long, xbean.CrossServerFriendsCircleGift> cross_server_send_gift;
/*      */     
/*      */     private HashMap<Long, xbean.CrossServerFriendsCircleTread> cross_server_tread;
/*      */     
/*      */     private HashMap<Long, xbean.FriendsCircleGiftResult> be_sent_gift;
/*      */     
/*      */     private HashMap<Long, xbean.FriendsCircleTreadResult> be_trod_result;
/*      */     
/*      */     private HashMap<Long, xbean.FriendsCirclePlaceTreasureResult> place_treasure_result;
/*      */     
/*      */     private boolean update_ornament_result;
/*      */     
/*      */     private int today_get_popularity_from_tread;
/*      */     
/*      */     private ArrayList<Long> my_black_role_list;
/*      */     
/*      */     private HashSet<Long> cross_server_black_in_role_set;
/*      */     
/*      */     private HashMap<Long, xbean.CrossServerFriendsCircleBlackRole> cross_server_black_operator;
/*      */     
/*      */     private int repair_tread;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 2410 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 2415 */       this.today_tread_circle_role_id_map = new HashMap();
/* 2416 */       this.today_tread_my_circle_role_id_map = new HashMap();
/* 2417 */       this.own_pendant_ornament_map = new HashMap();
/* 2418 */       this.own_rahmen_ornament_map = new HashMap();
/* 2419 */       this.current_pendant_ornament = new FriendsCircleOrnamentItem.Data();
/* 2420 */       this.current_rahmen_ornament = new FriendsCircleOrnamentItem.Data();
/* 2421 */       this.cross_server_send_gift = new HashMap();
/* 2422 */       this.cross_server_tread = new HashMap();
/* 2423 */       this.be_sent_gift = new HashMap();
/* 2424 */       this.be_trod_result = new HashMap();
/* 2425 */       this.place_treasure_result = new HashMap();
/* 2426 */       this.update_ornament_result = true;
/* 2427 */       this.my_black_role_list = new ArrayList();
/* 2428 */       this.cross_server_black_in_role_set = new HashSet();
/* 2429 */       this.cross_server_black_operator = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.Role2FriendsCircleInfo _o1_)
/*      */     {
/* 2434 */       if ((_o1_ instanceof Role2FriendsCircleInfo)) { assign((Role2FriendsCircleInfo)_o1_);
/* 2435 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 2436 */       } else if ((_o1_ instanceof Role2FriendsCircleInfo.Const)) assign(((Role2FriendsCircleInfo.Const)_o1_).nThis()); else {
/* 2437 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Role2FriendsCircleInfo _o_) {
/* 2442 */       this.treasure_box_num = _o_.treasure_box_num;
/* 2443 */       this.today_get_treasure_box_num = _o_.today_get_treasure_box_num;
/* 2444 */       this.last_get_treasure_box_time = _o_.last_get_treasure_box_time;
/* 2445 */       this.last_week_popularity_value_refresh_time = _o_.last_week_popularity_value_refresh_time;
/* 2446 */       this.current_week_popularity_value = _o_.current_week_popularity_value;
/* 2447 */       this.total_popularity_value = _o_.total_popularity_value;
/* 2448 */       this.receive_gift_num = _o_.receive_gift_num;
/* 2449 */       this.today_tread_circle_role_id_map = new HashMap();
/* 2450 */       for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_circle_role_id_map.entrySet())
/* 2451 */         this.today_tread_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/* 2452 */       this.last_tread_circle_time = _o_.last_tread_circle_time;
/* 2453 */       this.today_tread_my_circle_role_id_map = new HashMap();
/* 2454 */       for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_my_circle_role_id_map.entrySet())
/* 2455 */         this.today_tread_my_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/* 2456 */       this.last_tread_my_circle_time = _o_.last_tread_my_circle_time;
/* 2457 */       this.own_pendant_ornament_map = new HashMap();
/* 2458 */       for (Map.Entry<Integer, Long> _e_ : _o_.own_pendant_ornament_map.entrySet())
/* 2459 */         this.own_pendant_ornament_map.put(_e_.getKey(), _e_.getValue());
/* 2460 */       this.own_rahmen_ornament_map = new HashMap();
/* 2461 */       for (Map.Entry<Integer, Long> _e_ : _o_.own_rahmen_ornament_map.entrySet())
/* 2462 */         this.own_rahmen_ornament_map.put(_e_.getKey(), _e_.getValue());
/* 2463 */       this.current_pendant_ornament = new FriendsCircleOrnamentItem.Data(_o_.current_pendant_ornament);
/* 2464 */       this.current_rahmen_ornament = new FriendsCircleOrnamentItem.Data(_o_.current_rahmen_ornament);
/* 2465 */       this.cross_server_send_gift = new HashMap();
/* 2466 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : _o_.cross_server_send_gift.entrySet())
/* 2467 */         this.cross_server_send_gift.put(_e_.getKey(), new CrossServerFriendsCircleGift.Data((xbean.CrossServerFriendsCircleGift)_e_.getValue()));
/* 2468 */       this.cross_server_tread = new HashMap();
/* 2469 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : _o_.cross_server_tread.entrySet())
/* 2470 */         this.cross_server_tread.put(_e_.getKey(), new CrossServerFriendsCircleTread.Data((xbean.CrossServerFriendsCircleTread)_e_.getValue()));
/* 2471 */       this.be_sent_gift = new HashMap();
/* 2472 */       for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : _o_.be_sent_gift.entrySet())
/* 2473 */         this.be_sent_gift.put(_e_.getKey(), new FriendsCircleGiftResult.Data((xbean.FriendsCircleGiftResult)_e_.getValue()));
/* 2474 */       this.be_trod_result = new HashMap();
/* 2475 */       for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : _o_.be_trod_result.entrySet())
/* 2476 */         this.be_trod_result.put(_e_.getKey(), new FriendsCircleTreadResult.Data((xbean.FriendsCircleTreadResult)_e_.getValue()));
/* 2477 */       this.place_treasure_result = new HashMap();
/* 2478 */       for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : _o_.place_treasure_result.entrySet())
/* 2479 */         this.place_treasure_result.put(_e_.getKey(), new FriendsCirclePlaceTreasureResult.Data((xbean.FriendsCirclePlaceTreasureResult)_e_.getValue()));
/* 2480 */       this.update_ornament_result = _o_.update_ornament_result;
/* 2481 */       this.today_get_popularity_from_tread = _o_.today_get_popularity_from_tread;
/* 2482 */       this.my_black_role_list = new ArrayList();
/* 2483 */       this.my_black_role_list.addAll(_o_.my_black_role_list);
/* 2484 */       this.cross_server_black_in_role_set = new HashSet();
/* 2485 */       this.cross_server_black_in_role_set.addAll(_o_.cross_server_black_in_role_set);
/* 2486 */       this.cross_server_black_operator = new HashMap();
/* 2487 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : _o_.cross_server_black_operator.entrySet())
/* 2488 */         this.cross_server_black_operator.put(_e_.getKey(), new CrossServerFriendsCircleBlackRole.Data((xbean.CrossServerFriendsCircleBlackRole)_e_.getValue()));
/* 2489 */       this.repair_tread = _o_.repair_tread;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 2494 */       this.treasure_box_num = _o_.treasure_box_num;
/* 2495 */       this.today_get_treasure_box_num = _o_.today_get_treasure_box_num;
/* 2496 */       this.last_get_treasure_box_time = _o_.last_get_treasure_box_time;
/* 2497 */       this.last_week_popularity_value_refresh_time = _o_.last_week_popularity_value_refresh_time;
/* 2498 */       this.current_week_popularity_value = _o_.current_week_popularity_value;
/* 2499 */       this.total_popularity_value = _o_.total_popularity_value;
/* 2500 */       this.receive_gift_num = _o_.receive_gift_num;
/* 2501 */       this.today_tread_circle_role_id_map = new HashMap();
/* 2502 */       for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_circle_role_id_map.entrySet())
/* 2503 */         this.today_tread_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/* 2504 */       this.last_tread_circle_time = _o_.last_tread_circle_time;
/* 2505 */       this.today_tread_my_circle_role_id_map = new HashMap();
/* 2506 */       for (Map.Entry<Long, Integer> _e_ : _o_.today_tread_my_circle_role_id_map.entrySet())
/* 2507 */         this.today_tread_my_circle_role_id_map.put(_e_.getKey(), _e_.getValue());
/* 2508 */       this.last_tread_my_circle_time = _o_.last_tread_my_circle_time;
/* 2509 */       this.own_pendant_ornament_map = new HashMap();
/* 2510 */       for (Map.Entry<Integer, Long> _e_ : _o_.own_pendant_ornament_map.entrySet())
/* 2511 */         this.own_pendant_ornament_map.put(_e_.getKey(), _e_.getValue());
/* 2512 */       this.own_rahmen_ornament_map = new HashMap();
/* 2513 */       for (Map.Entry<Integer, Long> _e_ : _o_.own_rahmen_ornament_map.entrySet())
/* 2514 */         this.own_rahmen_ornament_map.put(_e_.getKey(), _e_.getValue());
/* 2515 */       this.current_pendant_ornament = new FriendsCircleOrnamentItem.Data(_o_.current_pendant_ornament);
/* 2516 */       this.current_rahmen_ornament = new FriendsCircleOrnamentItem.Data(_o_.current_rahmen_ornament);
/* 2517 */       this.cross_server_send_gift = new HashMap();
/* 2518 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : _o_.cross_server_send_gift.entrySet())
/* 2519 */         this.cross_server_send_gift.put(_e_.getKey(), new CrossServerFriendsCircleGift.Data((xbean.CrossServerFriendsCircleGift)_e_.getValue()));
/* 2520 */       this.cross_server_tread = new HashMap();
/* 2521 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : _o_.cross_server_tread.entrySet())
/* 2522 */         this.cross_server_tread.put(_e_.getKey(), new CrossServerFriendsCircleTread.Data((xbean.CrossServerFriendsCircleTread)_e_.getValue()));
/* 2523 */       this.be_sent_gift = new HashMap();
/* 2524 */       for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : _o_.be_sent_gift.entrySet())
/* 2525 */         this.be_sent_gift.put(_e_.getKey(), new FriendsCircleGiftResult.Data((xbean.FriendsCircleGiftResult)_e_.getValue()));
/* 2526 */       this.be_trod_result = new HashMap();
/* 2527 */       for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : _o_.be_trod_result.entrySet())
/* 2528 */         this.be_trod_result.put(_e_.getKey(), new FriendsCircleTreadResult.Data((xbean.FriendsCircleTreadResult)_e_.getValue()));
/* 2529 */       this.place_treasure_result = new HashMap();
/* 2530 */       for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : _o_.place_treasure_result.entrySet())
/* 2531 */         this.place_treasure_result.put(_e_.getKey(), new FriendsCirclePlaceTreasureResult.Data((xbean.FriendsCirclePlaceTreasureResult)_e_.getValue()));
/* 2532 */       this.update_ornament_result = _o_.update_ornament_result;
/* 2533 */       this.today_get_popularity_from_tread = _o_.today_get_popularity_from_tread;
/* 2534 */       this.my_black_role_list = new ArrayList();
/* 2535 */       this.my_black_role_list.addAll(_o_.my_black_role_list);
/* 2536 */       this.cross_server_black_in_role_set = new HashSet();
/* 2537 */       this.cross_server_black_in_role_set.addAll(_o_.cross_server_black_in_role_set);
/* 2538 */       this.cross_server_black_operator = new HashMap();
/* 2539 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : _o_.cross_server_black_operator.entrySet())
/* 2540 */         this.cross_server_black_operator.put(_e_.getKey(), new CrossServerFriendsCircleBlackRole.Data((xbean.CrossServerFriendsCircleBlackRole)_e_.getValue()));
/* 2541 */       this.repair_tread = _o_.repair_tread;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2547 */       _os_.marshal(this.treasure_box_num);
/* 2548 */       _os_.marshal(this.today_get_treasure_box_num);
/* 2549 */       _os_.marshal(this.last_get_treasure_box_time);
/* 2550 */       _os_.marshal(this.last_week_popularity_value_refresh_time);
/* 2551 */       _os_.marshal(this.current_week_popularity_value);
/* 2552 */       _os_.marshal(this.total_popularity_value);
/* 2553 */       _os_.marshal(this.receive_gift_num);
/* 2554 */       _os_.compact_uint32(this.today_tread_circle_role_id_map.size());
/* 2555 */       for (Map.Entry<Long, Integer> _e_ : this.today_tread_circle_role_id_map.entrySet())
/*      */       {
/* 2557 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2558 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2560 */       _os_.marshal(this.last_tread_circle_time);
/* 2561 */       _os_.compact_uint32(this.today_tread_my_circle_role_id_map.size());
/* 2562 */       for (Map.Entry<Long, Integer> _e_ : this.today_tread_my_circle_role_id_map.entrySet())
/*      */       {
/* 2564 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2565 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2567 */       _os_.marshal(this.last_tread_my_circle_time);
/* 2568 */       _os_.compact_uint32(this.own_pendant_ornament_map.size());
/* 2569 */       for (Map.Entry<Integer, Long> _e_ : this.own_pendant_ornament_map.entrySet())
/*      */       {
/* 2571 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2572 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/* 2574 */       _os_.compact_uint32(this.own_rahmen_ornament_map.size());
/* 2575 */       for (Map.Entry<Integer, Long> _e_ : this.own_rahmen_ornament_map.entrySet())
/*      */       {
/* 2577 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2578 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/* 2580 */       this.current_pendant_ornament.marshal(_os_);
/* 2581 */       this.current_rahmen_ornament.marshal(_os_);
/* 2582 */       _os_.compact_uint32(this.cross_server_send_gift.size());
/* 2583 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : this.cross_server_send_gift.entrySet())
/*      */       {
/* 2585 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2586 */         ((xbean.CrossServerFriendsCircleGift)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2588 */       _os_.compact_uint32(this.cross_server_tread.size());
/* 2589 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : this.cross_server_tread.entrySet())
/*      */       {
/* 2591 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2592 */         ((xbean.CrossServerFriendsCircleTread)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2594 */       _os_.compact_uint32(this.be_sent_gift.size());
/* 2595 */       for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : this.be_sent_gift.entrySet())
/*      */       {
/* 2597 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2598 */         ((xbean.FriendsCircleGiftResult)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2600 */       _os_.compact_uint32(this.be_trod_result.size());
/* 2601 */       for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : this.be_trod_result.entrySet())
/*      */       {
/* 2603 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2604 */         ((xbean.FriendsCircleTreadResult)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2606 */       _os_.compact_uint32(this.place_treasure_result.size());
/* 2607 */       for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : this.place_treasure_result.entrySet())
/*      */       {
/* 2609 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2610 */         ((xbean.FriendsCirclePlaceTreasureResult)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2612 */       _os_.marshal(this.update_ornament_result);
/* 2613 */       _os_.marshal(this.today_get_popularity_from_tread);
/* 2614 */       _os_.compact_uint32(this.my_black_role_list.size());
/* 2615 */       for (Long _v_ : this.my_black_role_list)
/*      */       {
/* 2617 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 2619 */       _os_.compact_uint32(this.cross_server_black_in_role_set.size());
/* 2620 */       for (Long _v_ : this.cross_server_black_in_role_set)
/*      */       {
/* 2622 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 2624 */       _os_.compact_uint32(this.cross_server_black_operator.size());
/* 2625 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : this.cross_server_black_operator.entrySet())
/*      */       {
/* 2627 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2628 */         ((xbean.CrossServerFriendsCircleBlackRole)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2630 */       _os_.marshal(this.repair_tread);
/* 2631 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2637 */       this.treasure_box_num = _os_.unmarshal_int();
/* 2638 */       this.today_get_treasure_box_num = _os_.unmarshal_int();
/* 2639 */       this.last_get_treasure_box_time = _os_.unmarshal_long();
/* 2640 */       this.last_week_popularity_value_refresh_time = _os_.unmarshal_long();
/* 2641 */       this.current_week_popularity_value = _os_.unmarshal_int();
/* 2642 */       this.total_popularity_value = _os_.unmarshal_int();
/* 2643 */       this.receive_gift_num = _os_.unmarshal_int();
/*      */       
/* 2645 */       int size = _os_.uncompact_uint32();
/* 2646 */       if (size >= 12)
/*      */       {
/* 2648 */         this.today_tread_circle_role_id_map = new HashMap(size * 2);
/*      */       }
/* 2650 */       for (; size > 0; size--)
/*      */       {
/* 2652 */         long _k_ = 0L;
/* 2653 */         _k_ = _os_.unmarshal_long();
/* 2654 */         int _v_ = 0;
/* 2655 */         _v_ = _os_.unmarshal_int();
/* 2656 */         this.today_tread_circle_role_id_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 2659 */       this.last_tread_circle_time = _os_.unmarshal_long();
/*      */       
/* 2661 */       int size = _os_.uncompact_uint32();
/* 2662 */       if (size >= 12)
/*      */       {
/* 2664 */         this.today_tread_my_circle_role_id_map = new HashMap(size * 2);
/*      */       }
/* 2666 */       for (; size > 0; size--)
/*      */       {
/* 2668 */         long _k_ = 0L;
/* 2669 */         _k_ = _os_.unmarshal_long();
/* 2670 */         int _v_ = 0;
/* 2671 */         _v_ = _os_.unmarshal_int();
/* 2672 */         this.today_tread_my_circle_role_id_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 2675 */       this.last_tread_my_circle_time = _os_.unmarshal_long();
/*      */       
/* 2677 */       int size = _os_.uncompact_uint32();
/* 2678 */       if (size >= 12)
/*      */       {
/* 2680 */         this.own_pendant_ornament_map = new HashMap(size * 2);
/*      */       }
/* 2682 */       for (; size > 0; size--)
/*      */       {
/* 2684 */         int _k_ = 0;
/* 2685 */         _k_ = _os_.unmarshal_int();
/* 2686 */         long _v_ = 0L;
/* 2687 */         _v_ = _os_.unmarshal_long();
/* 2688 */         this.own_pendant_ornament_map.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 2692 */       int size = _os_.uncompact_uint32();
/* 2693 */       if (size >= 12)
/*      */       {
/* 2695 */         this.own_rahmen_ornament_map = new HashMap(size * 2);
/*      */       }
/* 2697 */       for (; size > 0; size--)
/*      */       {
/* 2699 */         int _k_ = 0;
/* 2700 */         _k_ = _os_.unmarshal_int();
/* 2701 */         long _v_ = 0L;
/* 2702 */         _v_ = _os_.unmarshal_long();
/* 2703 */         this.own_rahmen_ornament_map.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/* 2706 */       this.current_pendant_ornament.unmarshal(_os_);
/* 2707 */       this.current_rahmen_ornament.unmarshal(_os_);
/*      */       
/* 2709 */       int size = _os_.uncompact_uint32();
/* 2710 */       if (size >= 12)
/*      */       {
/* 2712 */         this.cross_server_send_gift = new HashMap(size * 2);
/*      */       }
/* 2714 */       for (; size > 0; size--)
/*      */       {
/* 2716 */         long _k_ = 0L;
/* 2717 */         _k_ = _os_.unmarshal_long();
/* 2718 */         xbean.CrossServerFriendsCircleGift _v_ = Pod.newCrossServerFriendsCircleGiftData();
/* 2719 */         _v_.unmarshal(_os_);
/* 2720 */         this.cross_server_send_gift.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2724 */       int size = _os_.uncompact_uint32();
/* 2725 */       if (size >= 12)
/*      */       {
/* 2727 */         this.cross_server_tread = new HashMap(size * 2);
/*      */       }
/* 2729 */       for (; size > 0; size--)
/*      */       {
/* 2731 */         long _k_ = 0L;
/* 2732 */         _k_ = _os_.unmarshal_long();
/* 2733 */         xbean.CrossServerFriendsCircleTread _v_ = Pod.newCrossServerFriendsCircleTreadData();
/* 2734 */         _v_.unmarshal(_os_);
/* 2735 */         this.cross_server_tread.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2739 */       int size = _os_.uncompact_uint32();
/* 2740 */       if (size >= 12)
/*      */       {
/* 2742 */         this.be_sent_gift = new HashMap(size * 2);
/*      */       }
/* 2744 */       for (; size > 0; size--)
/*      */       {
/* 2746 */         long _k_ = 0L;
/* 2747 */         _k_ = _os_.unmarshal_long();
/* 2748 */         xbean.FriendsCircleGiftResult _v_ = Pod.newFriendsCircleGiftResultData();
/* 2749 */         _v_.unmarshal(_os_);
/* 2750 */         this.be_sent_gift.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2754 */       int size = _os_.uncompact_uint32();
/* 2755 */       if (size >= 12)
/*      */       {
/* 2757 */         this.be_trod_result = new HashMap(size * 2);
/*      */       }
/* 2759 */       for (; size > 0; size--)
/*      */       {
/* 2761 */         long _k_ = 0L;
/* 2762 */         _k_ = _os_.unmarshal_long();
/* 2763 */         xbean.FriendsCircleTreadResult _v_ = Pod.newFriendsCircleTreadResultData();
/* 2764 */         _v_.unmarshal(_os_);
/* 2765 */         this.be_trod_result.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2769 */       int size = _os_.uncompact_uint32();
/* 2770 */       if (size >= 12)
/*      */       {
/* 2772 */         this.place_treasure_result = new HashMap(size * 2);
/*      */       }
/* 2774 */       for (; size > 0; size--)
/*      */       {
/* 2776 */         long _k_ = 0L;
/* 2777 */         _k_ = _os_.unmarshal_long();
/* 2778 */         xbean.FriendsCirclePlaceTreasureResult _v_ = Pod.newFriendsCirclePlaceTreasureResultData();
/* 2779 */         _v_.unmarshal(_os_);
/* 2780 */         this.place_treasure_result.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2783 */       this.update_ornament_result = _os_.unmarshal_boolean();
/* 2784 */       this.today_get_popularity_from_tread = _os_.unmarshal_int();
/* 2785 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2787 */         long _v_ = 0L;
/* 2788 */         _v_ = _os_.unmarshal_long();
/* 2789 */         this.my_black_role_list.add(Long.valueOf(_v_));
/*      */       }
/* 2791 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2793 */         long _v_ = 0L;
/* 2794 */         _v_ = _os_.unmarshal_long();
/* 2795 */         this.cross_server_black_in_role_set.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/* 2798 */       int size = _os_.uncompact_uint32();
/* 2799 */       if (size >= 12)
/*      */       {
/* 2801 */         this.cross_server_black_operator = new HashMap(size * 2);
/*      */       }
/* 2803 */       for (; size > 0; size--)
/*      */       {
/* 2805 */         long _k_ = 0L;
/* 2806 */         _k_ = _os_.unmarshal_long();
/* 2807 */         xbean.CrossServerFriendsCircleBlackRole _v_ = Pod.newCrossServerFriendsCircleBlackRoleData();
/* 2808 */         _v_.unmarshal(_os_);
/* 2809 */         this.cross_server_black_operator.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2812 */       this.repair_tread = _os_.unmarshal_int();
/* 2813 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2819 */       int _size_ = 0;
/* 2820 */       _size_ += CodedOutputStream.computeInt32Size(1, this.treasure_box_num);
/* 2821 */       _size_ += CodedOutputStream.computeInt32Size(2, this.today_get_treasure_box_num);
/* 2822 */       _size_ += CodedOutputStream.computeInt64Size(3, this.last_get_treasure_box_time);
/* 2823 */       _size_ += CodedOutputStream.computeInt64Size(4, this.last_week_popularity_value_refresh_time);
/* 2824 */       _size_ += CodedOutputStream.computeInt32Size(5, this.current_week_popularity_value);
/* 2825 */       _size_ += CodedOutputStream.computeInt32Size(6, this.total_popularity_value);
/* 2826 */       _size_ += CodedOutputStream.computeInt32Size(7, this.receive_gift_num);
/* 2827 */       for (Map.Entry<Long, Integer> _e_ : this.today_tread_circle_role_id_map.entrySet())
/*      */       {
/* 2829 */         _size_ += CodedOutputStream.computeInt64Size(8, ((Long)_e_.getKey()).longValue());
/* 2830 */         _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2832 */       _size_ += CodedOutputStream.computeInt64Size(9, this.last_tread_circle_time);
/* 2833 */       for (Map.Entry<Long, Integer> _e_ : this.today_tread_my_circle_role_id_map.entrySet())
/*      */       {
/* 2835 */         _size_ += CodedOutputStream.computeInt64Size(10, ((Long)_e_.getKey()).longValue());
/* 2836 */         _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2838 */       _size_ += CodedOutputStream.computeInt64Size(11, this.last_tread_my_circle_time);
/* 2839 */       for (Map.Entry<Integer, Long> _e_ : this.own_pendant_ornament_map.entrySet())
/*      */       {
/* 2841 */         _size_ += CodedOutputStream.computeInt32Size(15, ((Integer)_e_.getKey()).intValue());
/* 2842 */         _size_ += CodedOutputStream.computeInt64Size(15, ((Long)_e_.getValue()).longValue());
/*      */       }
/* 2844 */       for (Map.Entry<Integer, Long> _e_ : this.own_rahmen_ornament_map.entrySet())
/*      */       {
/* 2846 */         _size_ += CodedOutputStream.computeInt32Size(16, ((Integer)_e_.getKey()).intValue());
/* 2847 */         _size_ += CodedOutputStream.computeInt64Size(16, ((Long)_e_.getValue()).longValue());
/*      */       }
/* 2849 */       _size_ += CodedOutputStream.computeMessageSize(17, this.current_pendant_ornament);
/* 2850 */       _size_ += CodedOutputStream.computeMessageSize(18, this.current_rahmen_ornament);
/* 2851 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : this.cross_server_send_gift.entrySet())
/*      */       {
/* 2853 */         _size_ += CodedOutputStream.computeInt64Size(19, ((Long)_e_.getKey()).longValue());
/* 2854 */         _size_ += CodedOutputStream.computeMessageSize(19, (Message)_e_.getValue());
/*      */       }
/* 2856 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : this.cross_server_tread.entrySet())
/*      */       {
/* 2858 */         _size_ += CodedOutputStream.computeInt64Size(20, ((Long)_e_.getKey()).longValue());
/* 2859 */         _size_ += CodedOutputStream.computeMessageSize(20, (Message)_e_.getValue());
/*      */       }
/* 2861 */       for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : this.be_sent_gift.entrySet())
/*      */       {
/* 2863 */         _size_ += CodedOutputStream.computeInt64Size(21, ((Long)_e_.getKey()).longValue());
/* 2864 */         _size_ += CodedOutputStream.computeMessageSize(21, (Message)_e_.getValue());
/*      */       }
/* 2866 */       for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : this.be_trod_result.entrySet())
/*      */       {
/* 2868 */         _size_ += CodedOutputStream.computeInt64Size(22, ((Long)_e_.getKey()).longValue());
/* 2869 */         _size_ += CodedOutputStream.computeMessageSize(22, (Message)_e_.getValue());
/*      */       }
/* 2871 */       for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : this.place_treasure_result.entrySet())
/*      */       {
/* 2873 */         _size_ += CodedOutputStream.computeInt64Size(23, ((Long)_e_.getKey()).longValue());
/* 2874 */         _size_ += CodedOutputStream.computeMessageSize(23, (Message)_e_.getValue());
/*      */       }
/* 2876 */       _size_ += CodedOutputStream.computeBoolSize(24, this.update_ornament_result);
/* 2877 */       _size_ += CodedOutputStream.computeInt32Size(25, this.today_get_popularity_from_tread);
/* 2878 */       for (Long _v_ : this.my_black_role_list)
/*      */       {
/* 2880 */         _size_ += CodedOutputStream.computeInt64Size(26, _v_.longValue());
/*      */       }
/* 2882 */       for (Long _v_ : this.cross_server_black_in_role_set)
/*      */       {
/* 2884 */         _size_ += CodedOutputStream.computeInt64Size(27, _v_.longValue());
/*      */       }
/* 2886 */       for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : this.cross_server_black_operator.entrySet())
/*      */       {
/* 2888 */         _size_ += CodedOutputStream.computeInt64Size(28, ((Long)_e_.getKey()).longValue());
/* 2889 */         _size_ += CodedOutputStream.computeMessageSize(28, (Message)_e_.getValue());
/*      */       }
/* 2891 */       _size_ += CodedOutputStream.computeInt32Size(29, this.repair_tread);
/* 2892 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2900 */         _output_.writeInt32(1, this.treasure_box_num);
/* 2901 */         _output_.writeInt32(2, this.today_get_treasure_box_num);
/* 2902 */         _output_.writeInt64(3, this.last_get_treasure_box_time);
/* 2903 */         _output_.writeInt64(4, this.last_week_popularity_value_refresh_time);
/* 2904 */         _output_.writeInt32(5, this.current_week_popularity_value);
/* 2905 */         _output_.writeInt32(6, this.total_popularity_value);
/* 2906 */         _output_.writeInt32(7, this.receive_gift_num);
/* 2907 */         for (Map.Entry<Long, Integer> _e_ : this.today_tread_circle_role_id_map.entrySet())
/*      */         {
/* 2909 */           _output_.writeInt64(8, ((Long)_e_.getKey()).longValue());
/* 2910 */           _output_.writeInt32(8, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2912 */         _output_.writeInt64(9, this.last_tread_circle_time);
/* 2913 */         for (Map.Entry<Long, Integer> _e_ : this.today_tread_my_circle_role_id_map.entrySet())
/*      */         {
/* 2915 */           _output_.writeInt64(10, ((Long)_e_.getKey()).longValue());
/* 2916 */           _output_.writeInt32(10, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2918 */         _output_.writeInt64(11, this.last_tread_my_circle_time);
/* 2919 */         for (Map.Entry<Integer, Long> _e_ : this.own_pendant_ornament_map.entrySet())
/*      */         {
/* 2921 */           _output_.writeInt32(15, ((Integer)_e_.getKey()).intValue());
/* 2922 */           _output_.writeInt64(15, ((Long)_e_.getValue()).longValue());
/*      */         }
/* 2924 */         for (Map.Entry<Integer, Long> _e_ : this.own_rahmen_ornament_map.entrySet())
/*      */         {
/* 2926 */           _output_.writeInt32(16, ((Integer)_e_.getKey()).intValue());
/* 2927 */           _output_.writeInt64(16, ((Long)_e_.getValue()).longValue());
/*      */         }
/* 2929 */         _output_.writeMessage(17, this.current_pendant_ornament);
/* 2930 */         _output_.writeMessage(18, this.current_rahmen_ornament);
/* 2931 */         for (Map.Entry<Long, xbean.CrossServerFriendsCircleGift> _e_ : this.cross_server_send_gift.entrySet())
/*      */         {
/* 2933 */           _output_.writeInt64(19, ((Long)_e_.getKey()).longValue());
/* 2934 */           _output_.writeMessage(19, (Message)_e_.getValue());
/*      */         }
/* 2936 */         for (Map.Entry<Long, xbean.CrossServerFriendsCircleTread> _e_ : this.cross_server_tread.entrySet())
/*      */         {
/* 2938 */           _output_.writeInt64(20, ((Long)_e_.getKey()).longValue());
/* 2939 */           _output_.writeMessage(20, (Message)_e_.getValue());
/*      */         }
/* 2941 */         for (Map.Entry<Long, xbean.FriendsCircleGiftResult> _e_ : this.be_sent_gift.entrySet())
/*      */         {
/* 2943 */           _output_.writeInt64(21, ((Long)_e_.getKey()).longValue());
/* 2944 */           _output_.writeMessage(21, (Message)_e_.getValue());
/*      */         }
/* 2946 */         for (Map.Entry<Long, xbean.FriendsCircleTreadResult> _e_ : this.be_trod_result.entrySet())
/*      */         {
/* 2948 */           _output_.writeInt64(22, ((Long)_e_.getKey()).longValue());
/* 2949 */           _output_.writeMessage(22, (Message)_e_.getValue());
/*      */         }
/* 2951 */         for (Map.Entry<Long, xbean.FriendsCirclePlaceTreasureResult> _e_ : this.place_treasure_result.entrySet())
/*      */         {
/* 2953 */           _output_.writeInt64(23, ((Long)_e_.getKey()).longValue());
/* 2954 */           _output_.writeMessage(23, (Message)_e_.getValue());
/*      */         }
/* 2956 */         _output_.writeBool(24, this.update_ornament_result);
/* 2957 */         _output_.writeInt32(25, this.today_get_popularity_from_tread);
/* 2958 */         for (Long _v_ : this.my_black_role_list)
/*      */         {
/* 2960 */           _output_.writeInt64(26, _v_.longValue());
/*      */         }
/* 2962 */         for (Long _v_ : this.cross_server_black_in_role_set)
/*      */         {
/* 2964 */           _output_.writeInt64(27, _v_.longValue());
/*      */         }
/* 2966 */         for (Map.Entry<Long, xbean.CrossServerFriendsCircleBlackRole> _e_ : this.cross_server_black_operator.entrySet())
/*      */         {
/* 2968 */           _output_.writeInt64(28, ((Long)_e_.getKey()).longValue());
/* 2969 */           _output_.writeMessage(28, (Message)_e_.getValue());
/*      */         }
/* 2971 */         _output_.writeInt32(29, this.repair_tread);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2975 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2977 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2985 */         boolean done = false;
/* 2986 */         while (!done)
/*      */         {
/* 2988 */           int tag = _input_.readTag();
/* 2989 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 2993 */             done = true;
/* 2994 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 2998 */             this.treasure_box_num = _input_.readInt32();
/* 2999 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 3003 */             this.today_get_treasure_box_num = _input_.readInt32();
/* 3004 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 3008 */             this.last_get_treasure_box_time = _input_.readInt64();
/* 3009 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 3013 */             this.last_week_popularity_value_refresh_time = _input_.readInt64();
/* 3014 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 3018 */             this.current_week_popularity_value = _input_.readInt32();
/* 3019 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 3023 */             this.total_popularity_value = _input_.readInt32();
/* 3024 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 3028 */             this.receive_gift_num = _input_.readInt32();
/* 3029 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 3033 */             long _k_ = 0L;
/* 3034 */             _k_ = _input_.readInt64();
/* 3035 */             int readTag = _input_.readTag();
/* 3036 */             if (64 != readTag)
/*      */             {
/* 3038 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3040 */             int _v_ = 0;
/* 3041 */             _v_ = _input_.readInt32();
/* 3042 */             this.today_tread_circle_role_id_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 3043 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 3047 */             this.last_tread_circle_time = _input_.readInt64();
/* 3048 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 3052 */             long _k_ = 0L;
/* 3053 */             _k_ = _input_.readInt64();
/* 3054 */             int readTag = _input_.readTag();
/* 3055 */             if (80 != readTag)
/*      */             {
/* 3057 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3059 */             int _v_ = 0;
/* 3060 */             _v_ = _input_.readInt32();
/* 3061 */             this.today_tread_my_circle_role_id_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 3062 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 3066 */             this.last_tread_my_circle_time = _input_.readInt64();
/* 3067 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 3071 */             int _k_ = 0;
/* 3072 */             _k_ = _input_.readInt32();
/* 3073 */             int readTag = _input_.readTag();
/* 3074 */             if (120 != readTag)
/*      */             {
/* 3076 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3078 */             long _v_ = 0L;
/* 3079 */             _v_ = _input_.readInt64();
/* 3080 */             this.own_pendant_ornament_map.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 3081 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 3085 */             int _k_ = 0;
/* 3086 */             _k_ = _input_.readInt32();
/* 3087 */             int readTag = _input_.readTag();
/* 3088 */             if (128 != readTag)
/*      */             {
/* 3090 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3092 */             long _v_ = 0L;
/* 3093 */             _v_ = _input_.readInt64();
/* 3094 */             this.own_rahmen_ornament_map.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 3095 */             break;
/*      */           
/*      */ 
/*      */           case 138: 
/* 3099 */             _input_.readMessage(this.current_pendant_ornament);
/* 3100 */             break;
/*      */           
/*      */ 
/*      */           case 146: 
/* 3104 */             _input_.readMessage(this.current_rahmen_ornament);
/* 3105 */             break;
/*      */           
/*      */ 
/*      */           case 152: 
/* 3109 */             long _k_ = 0L;
/* 3110 */             _k_ = _input_.readInt64();
/* 3111 */             int readTag = _input_.readTag();
/* 3112 */             if (154 != readTag)
/*      */             {
/* 3114 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3116 */             xbean.CrossServerFriendsCircleGift _v_ = Pod.newCrossServerFriendsCircleGiftData();
/* 3117 */             _input_.readMessage(_v_);
/* 3118 */             this.cross_server_send_gift.put(Long.valueOf(_k_), _v_);
/* 3119 */             break;
/*      */           
/*      */ 
/*      */           case 160: 
/* 3123 */             long _k_ = 0L;
/* 3124 */             _k_ = _input_.readInt64();
/* 3125 */             int readTag = _input_.readTag();
/* 3126 */             if (162 != readTag)
/*      */             {
/* 3128 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3130 */             xbean.CrossServerFriendsCircleTread _v_ = Pod.newCrossServerFriendsCircleTreadData();
/* 3131 */             _input_.readMessage(_v_);
/* 3132 */             this.cross_server_tread.put(Long.valueOf(_k_), _v_);
/* 3133 */             break;
/*      */           
/*      */ 
/*      */           case 168: 
/* 3137 */             long _k_ = 0L;
/* 3138 */             _k_ = _input_.readInt64();
/* 3139 */             int readTag = _input_.readTag();
/* 3140 */             if (170 != readTag)
/*      */             {
/* 3142 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3144 */             xbean.FriendsCircleGiftResult _v_ = Pod.newFriendsCircleGiftResultData();
/* 3145 */             _input_.readMessage(_v_);
/* 3146 */             this.be_sent_gift.put(Long.valueOf(_k_), _v_);
/* 3147 */             break;
/*      */           
/*      */ 
/*      */           case 176: 
/* 3151 */             long _k_ = 0L;
/* 3152 */             _k_ = _input_.readInt64();
/* 3153 */             int readTag = _input_.readTag();
/* 3154 */             if (178 != readTag)
/*      */             {
/* 3156 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3158 */             xbean.FriendsCircleTreadResult _v_ = Pod.newFriendsCircleTreadResultData();
/* 3159 */             _input_.readMessage(_v_);
/* 3160 */             this.be_trod_result.put(Long.valueOf(_k_), _v_);
/* 3161 */             break;
/*      */           
/*      */ 
/*      */           case 184: 
/* 3165 */             long _k_ = 0L;
/* 3166 */             _k_ = _input_.readInt64();
/* 3167 */             int readTag = _input_.readTag();
/* 3168 */             if (186 != readTag)
/*      */             {
/* 3170 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3172 */             xbean.FriendsCirclePlaceTreasureResult _v_ = Pod.newFriendsCirclePlaceTreasureResultData();
/* 3173 */             _input_.readMessage(_v_);
/* 3174 */             this.place_treasure_result.put(Long.valueOf(_k_), _v_);
/* 3175 */             break;
/*      */           
/*      */ 
/*      */           case 192: 
/* 3179 */             this.update_ornament_result = _input_.readBool();
/* 3180 */             break;
/*      */           
/*      */ 
/*      */           case 200: 
/* 3184 */             this.today_get_popularity_from_tread = _input_.readInt32();
/* 3185 */             break;
/*      */           
/*      */ 
/*      */           case 208: 
/* 3189 */             long _v_ = 0L;
/* 3190 */             _v_ = _input_.readInt64();
/* 3191 */             this.my_black_role_list.add(Long.valueOf(_v_));
/* 3192 */             break;
/*      */           
/*      */ 
/*      */           case 216: 
/* 3196 */             long _v_ = 0L;
/* 3197 */             _v_ = _input_.readInt64();
/* 3198 */             this.cross_server_black_in_role_set.add(Long.valueOf(_v_));
/* 3199 */             break;
/*      */           
/*      */ 
/*      */           case 224: 
/* 3203 */             long _k_ = 0L;
/* 3204 */             _k_ = _input_.readInt64();
/* 3205 */             int readTag = _input_.readTag();
/* 3206 */             if (226 != readTag)
/*      */             {
/* 3208 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3210 */             xbean.CrossServerFriendsCircleBlackRole _v_ = Pod.newCrossServerFriendsCircleBlackRoleData();
/* 3211 */             _input_.readMessage(_v_);
/* 3212 */             this.cross_server_black_operator.put(Long.valueOf(_k_), _v_);
/* 3213 */             break;
/*      */           
/*      */ 
/*      */           case 232: 
/* 3217 */             this.repair_tread = _input_.readInt32();
/* 3218 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 3222 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 3224 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 3233 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 3237 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 3239 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FriendsCircleInfo copy()
/*      */     {
/* 3245 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FriendsCircleInfo toData()
/*      */     {
/* 3251 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Role2FriendsCircleInfo toBean()
/*      */     {
/* 3256 */       return new Role2FriendsCircleInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FriendsCircleInfo toDataIf()
/*      */     {
/* 3262 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Role2FriendsCircleInfo toBeanIf()
/*      */     {
/* 3267 */       return new Role2FriendsCircleInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 3273 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 3277 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 3281 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 3285 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 3289 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 3293 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 3297 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTreasure_box_num()
/*      */     {
/* 3304 */       return this.treasure_box_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getToday_get_treasure_box_num()
/*      */     {
/* 3311 */       return this.today_get_treasure_box_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_get_treasure_box_time()
/*      */     {
/* 3318 */       return this.last_get_treasure_box_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_week_popularity_value_refresh_time()
/*      */     {
/* 3325 */       return this.last_week_popularity_value_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_week_popularity_value()
/*      */     {
/* 3332 */       return this.current_week_popularity_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_popularity_value()
/*      */     {
/* 3339 */       return this.total_popularity_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReceive_gift_num()
/*      */     {
/* 3346 */       return this.receive_gift_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getToday_tread_circle_role_id_map()
/*      */     {
/* 3353 */       return this.today_tread_circle_role_id_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getToday_tread_circle_role_id_mapAsData()
/*      */     {
/* 3360 */       return this.today_tread_circle_role_id_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_tread_circle_time()
/*      */     {
/* 3367 */       return this.last_tread_circle_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getToday_tread_my_circle_role_id_map()
/*      */     {
/* 3374 */       return this.today_tread_my_circle_role_id_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getToday_tread_my_circle_role_id_mapAsData()
/*      */     {
/* 3381 */       return this.today_tread_my_circle_role_id_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_tread_my_circle_time()
/*      */     {
/* 3388 */       return this.last_tread_my_circle_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getOwn_pendant_ornament_map()
/*      */     {
/* 3395 */       return this.own_pendant_ornament_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getOwn_pendant_ornament_mapAsData()
/*      */     {
/* 3402 */       return this.own_pendant_ornament_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getOwn_rahmen_ornament_map()
/*      */     {
/* 3409 */       return this.own_rahmen_ornament_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getOwn_rahmen_ornament_mapAsData()
/*      */     {
/* 3416 */       return this.own_rahmen_ornament_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FriendsCircleOrnamentItem getCurrent_pendant_ornament()
/*      */     {
/* 3423 */       return this.current_pendant_ornament;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FriendsCircleOrnamentItem getCurrent_rahmen_ornament()
/*      */     {
/* 3430 */       return this.current_rahmen_ornament;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleGift> getCross_server_send_gift()
/*      */     {
/* 3437 */       return this.cross_server_send_gift;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleGift> getCross_server_send_giftAsData()
/*      */     {
/* 3444 */       return this.cross_server_send_gift;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleTread> getCross_server_tread()
/*      */     {
/* 3451 */       return this.cross_server_tread;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleTread> getCross_server_treadAsData()
/*      */     {
/* 3458 */       return this.cross_server_tread;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCircleGiftResult> getBe_sent_gift()
/*      */     {
/* 3465 */       return this.be_sent_gift;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCircleGiftResult> getBe_sent_giftAsData()
/*      */     {
/* 3472 */       return this.be_sent_gift;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCircleTreadResult> getBe_trod_result()
/*      */     {
/* 3479 */       return this.be_trod_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCircleTreadResult> getBe_trod_resultAsData()
/*      */     {
/* 3486 */       return this.be_trod_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCirclePlaceTreasureResult> getPlace_treasure_result()
/*      */     {
/* 3493 */       return this.place_treasure_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FriendsCirclePlaceTreasureResult> getPlace_treasure_resultAsData()
/*      */     {
/* 3500 */       return this.place_treasure_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getUpdate_ornament_result()
/*      */     {
/* 3507 */       return this.update_ornament_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getToday_get_popularity_from_tread()
/*      */     {
/* 3514 */       return this.today_get_popularity_from_tread;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMy_black_role_list()
/*      */     {
/* 3521 */       return this.my_black_role_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMy_black_role_listAsData()
/*      */     {
/* 3528 */       return this.my_black_role_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCross_server_black_in_role_set()
/*      */     {
/* 3535 */       return this.cross_server_black_in_role_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCross_server_black_in_role_setAsData()
/*      */     {
/* 3542 */       return this.cross_server_black_in_role_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleBlackRole> getCross_server_black_operator()
/*      */     {
/* 3549 */       return this.cross_server_black_operator;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossServerFriendsCircleBlackRole> getCross_server_black_operatorAsData()
/*      */     {
/* 3556 */       return this.cross_server_black_operator;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRepair_tread()
/*      */     {
/* 3563 */       return this.repair_tread;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTreasure_box_num(int _v_)
/*      */     {
/* 3570 */       this.treasure_box_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setToday_get_treasure_box_num(int _v_)
/*      */     {
/* 3577 */       this.today_get_treasure_box_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_get_treasure_box_time(long _v_)
/*      */     {
/* 3584 */       this.last_get_treasure_box_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_week_popularity_value_refresh_time(long _v_)
/*      */     {
/* 3591 */       this.last_week_popularity_value_refresh_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_week_popularity_value(int _v_)
/*      */     {
/* 3598 */       this.current_week_popularity_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_popularity_value(int _v_)
/*      */     {
/* 3605 */       this.total_popularity_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReceive_gift_num(int _v_)
/*      */     {
/* 3612 */       this.receive_gift_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_tread_circle_time(long _v_)
/*      */     {
/* 3619 */       this.last_tread_circle_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_tread_my_circle_time(long _v_)
/*      */     {
/* 3626 */       this.last_tread_my_circle_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdate_ornament_result(boolean _v_)
/*      */     {
/* 3633 */       this.update_ornament_result = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setToday_get_popularity_from_tread(int _v_)
/*      */     {
/* 3640 */       this.today_get_popularity_from_tread = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRepair_tread(int _v_)
/*      */     {
/* 3647 */       this.repair_tread = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 3653 */       if (!(_o1_ instanceof Data)) return false;
/* 3654 */       Data _o_ = (Data)_o1_;
/* 3655 */       if (this.treasure_box_num != _o_.treasure_box_num) return false;
/* 3656 */       if (this.today_get_treasure_box_num != _o_.today_get_treasure_box_num) return false;
/* 3657 */       if (this.last_get_treasure_box_time != _o_.last_get_treasure_box_time) return false;
/* 3658 */       if (this.last_week_popularity_value_refresh_time != _o_.last_week_popularity_value_refresh_time) return false;
/* 3659 */       if (this.current_week_popularity_value != _o_.current_week_popularity_value) return false;
/* 3660 */       if (this.total_popularity_value != _o_.total_popularity_value) return false;
/* 3661 */       if (this.receive_gift_num != _o_.receive_gift_num) return false;
/* 3662 */       if (!this.today_tread_circle_role_id_map.equals(_o_.today_tread_circle_role_id_map)) return false;
/* 3663 */       if (this.last_tread_circle_time != _o_.last_tread_circle_time) return false;
/* 3664 */       if (!this.today_tread_my_circle_role_id_map.equals(_o_.today_tread_my_circle_role_id_map)) return false;
/* 3665 */       if (this.last_tread_my_circle_time != _o_.last_tread_my_circle_time) return false;
/* 3666 */       if (!this.own_pendant_ornament_map.equals(_o_.own_pendant_ornament_map)) return false;
/* 3667 */       if (!this.own_rahmen_ornament_map.equals(_o_.own_rahmen_ornament_map)) return false;
/* 3668 */       if (!this.current_pendant_ornament.equals(_o_.current_pendant_ornament)) return false;
/* 3669 */       if (!this.current_rahmen_ornament.equals(_o_.current_rahmen_ornament)) return false;
/* 3670 */       if (!this.cross_server_send_gift.equals(_o_.cross_server_send_gift)) return false;
/* 3671 */       if (!this.cross_server_tread.equals(_o_.cross_server_tread)) return false;
/* 3672 */       if (!this.be_sent_gift.equals(_o_.be_sent_gift)) return false;
/* 3673 */       if (!this.be_trod_result.equals(_o_.be_trod_result)) return false;
/* 3674 */       if (!this.place_treasure_result.equals(_o_.place_treasure_result)) return false;
/* 3675 */       if (this.update_ornament_result != _o_.update_ornament_result) return false;
/* 3676 */       if (this.today_get_popularity_from_tread != _o_.today_get_popularity_from_tread) return false;
/* 3677 */       if (!this.my_black_role_list.equals(_o_.my_black_role_list)) return false;
/* 3678 */       if (!this.cross_server_black_in_role_set.equals(_o_.cross_server_black_in_role_set)) return false;
/* 3679 */       if (!this.cross_server_black_operator.equals(_o_.cross_server_black_operator)) return false;
/* 3680 */       if (this.repair_tread != _o_.repair_tread) return false;
/* 3681 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 3687 */       int _h_ = 0;
/* 3688 */       _h_ += this.treasure_box_num;
/* 3689 */       _h_ += this.today_get_treasure_box_num;
/* 3690 */       _h_ = (int)(_h_ + this.last_get_treasure_box_time);
/* 3691 */       _h_ = (int)(_h_ + this.last_week_popularity_value_refresh_time);
/* 3692 */       _h_ += this.current_week_popularity_value;
/* 3693 */       _h_ += this.total_popularity_value;
/* 3694 */       _h_ += this.receive_gift_num;
/* 3695 */       _h_ += this.today_tread_circle_role_id_map.hashCode();
/* 3696 */       _h_ = (int)(_h_ + this.last_tread_circle_time);
/* 3697 */       _h_ += this.today_tread_my_circle_role_id_map.hashCode();
/* 3698 */       _h_ = (int)(_h_ + this.last_tread_my_circle_time);
/* 3699 */       _h_ += this.own_pendant_ornament_map.hashCode();
/* 3700 */       _h_ += this.own_rahmen_ornament_map.hashCode();
/* 3701 */       _h_ += this.current_pendant_ornament.hashCode();
/* 3702 */       _h_ += this.current_rahmen_ornament.hashCode();
/* 3703 */       _h_ += this.cross_server_send_gift.hashCode();
/* 3704 */       _h_ += this.cross_server_tread.hashCode();
/* 3705 */       _h_ += this.be_sent_gift.hashCode();
/* 3706 */       _h_ += this.be_trod_result.hashCode();
/* 3707 */       _h_ += this.place_treasure_result.hashCode();
/* 3708 */       _h_ += (this.update_ornament_result ? 1231 : 1237);
/* 3709 */       _h_ += this.today_get_popularity_from_tread;
/* 3710 */       _h_ += this.my_black_role_list.hashCode();
/* 3711 */       _h_ += this.cross_server_black_in_role_set.hashCode();
/* 3712 */       _h_ += this.cross_server_black_operator.hashCode();
/* 3713 */       _h_ += this.repair_tread;
/* 3714 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 3720 */       StringBuilder _sb_ = new StringBuilder();
/* 3721 */       _sb_.append("(");
/* 3722 */       _sb_.append(this.treasure_box_num);
/* 3723 */       _sb_.append(",");
/* 3724 */       _sb_.append(this.today_get_treasure_box_num);
/* 3725 */       _sb_.append(",");
/* 3726 */       _sb_.append(this.last_get_treasure_box_time);
/* 3727 */       _sb_.append(",");
/* 3728 */       _sb_.append(this.last_week_popularity_value_refresh_time);
/* 3729 */       _sb_.append(",");
/* 3730 */       _sb_.append(this.current_week_popularity_value);
/* 3731 */       _sb_.append(",");
/* 3732 */       _sb_.append(this.total_popularity_value);
/* 3733 */       _sb_.append(",");
/* 3734 */       _sb_.append(this.receive_gift_num);
/* 3735 */       _sb_.append(",");
/* 3736 */       _sb_.append(this.today_tread_circle_role_id_map);
/* 3737 */       _sb_.append(",");
/* 3738 */       _sb_.append(this.last_tread_circle_time);
/* 3739 */       _sb_.append(",");
/* 3740 */       _sb_.append(this.today_tread_my_circle_role_id_map);
/* 3741 */       _sb_.append(",");
/* 3742 */       _sb_.append(this.last_tread_my_circle_time);
/* 3743 */       _sb_.append(",");
/* 3744 */       _sb_.append(this.own_pendant_ornament_map);
/* 3745 */       _sb_.append(",");
/* 3746 */       _sb_.append(this.own_rahmen_ornament_map);
/* 3747 */       _sb_.append(",");
/* 3748 */       _sb_.append(this.current_pendant_ornament);
/* 3749 */       _sb_.append(",");
/* 3750 */       _sb_.append(this.current_rahmen_ornament);
/* 3751 */       _sb_.append(",");
/* 3752 */       _sb_.append(this.cross_server_send_gift);
/* 3753 */       _sb_.append(",");
/* 3754 */       _sb_.append(this.cross_server_tread);
/* 3755 */       _sb_.append(",");
/* 3756 */       _sb_.append(this.be_sent_gift);
/* 3757 */       _sb_.append(",");
/* 3758 */       _sb_.append(this.be_trod_result);
/* 3759 */       _sb_.append(",");
/* 3760 */       _sb_.append(this.place_treasure_result);
/* 3761 */       _sb_.append(",");
/* 3762 */       _sb_.append(this.update_ornament_result);
/* 3763 */       _sb_.append(",");
/* 3764 */       _sb_.append(this.today_get_popularity_from_tread);
/* 3765 */       _sb_.append(",");
/* 3766 */       _sb_.append(this.my_black_role_list);
/* 3767 */       _sb_.append(",");
/* 3768 */       _sb_.append(this.cross_server_black_in_role_set);
/* 3769 */       _sb_.append(",");
/* 3770 */       _sb_.append(this.cross_server_black_operator);
/* 3771 */       _sb_.append(",");
/* 3772 */       _sb_.append(this.repair_tread);
/* 3773 */       _sb_.append(")");
/* 3774 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2FriendsCircleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */